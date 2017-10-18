package br.com.peoplehero.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.peoplehero.dominio.MoradorDeRua;
import br.com.peoplehero.persistencia.MoradorDeRuaRepositorio;

@RestController
public class MoradorDeRuaController {
	
	@Autowired
	private MoradorDeRuaRepositorio repositorio;

	@RequestMapping(value = "/moradores", method = RequestMethod.POST)
	@ResponseBody
	public MoradorDeRua salvar(@RequestBody MoradorDeRua morador) {
		return repositorio.save(morador);
	}

	@RequestMapping(value = "/moradores", method = RequestMethod.GET)
	@ResponseBody
	public List<MoradorDeRua> recuperarTodos() {
		return repositorio.findAll();
	}

	@RequestMapping(value = "/moradores/{id}", method = RequestMethod.GET)
	@ResponseBody
	public MoradorDeRua recuperarUm(@PathVariable Integer id) {
		return repositorio.findOne(id);
	}

	@RequestMapping(value = "/moradores", method = RequestMethod.PUT)
	@ResponseBody
	public MoradorDeRua atualizar(@RequestBody MoradorDeRua morador) {
		return repositorio.save(morador);
	}

	@RequestMapping(value = "/moradores/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String remover(@PathVariable Integer id) {
		try {
			repositorio.delete(id);
		} catch (EmptyResultDataAccessException e) {
			return id + " não encontrado";
		} catch (Exception e) {
			return "Erro interno no servidor, tente mais tarde";
		}
		return id + " removido";
	}
}
