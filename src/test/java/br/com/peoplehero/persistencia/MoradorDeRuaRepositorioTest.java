package br.com.peoplehero.persistencia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.peoplehero.dominio.MoradorDeRua;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoradorDeRuaRepositorioTest {
	
	@Autowired
	private MoradorDeRuaRepositorio repositorio;
	
	@Before
	public void setUp() {
		repositorio.deleteAll();
	}

	@Test
	public void salvarNovo() {
		MoradorDeRua moradorDoCentro = new MoradorDeRua(10.0, -10.0);
		MoradorDeRua moradorSalvo = repositorio.save(moradorDoCentro);
		assertEquals(Double.valueOf(10), moradorSalvo.getLatitude());
	}
	
	@Test
	public void listar() {
		MoradorDeRua moradorDoCentro = new MoradorDeRua(10.0, -10.0);
		MoradorDeRua moradorDoCentro1 = new MoradorDeRua(10.0, -10.0);
		MoradorDeRua moradorDoCentro2 = new MoradorDeRua(10.0, -10.0);
		repositorio.save(moradorDoCentro);
		repositorio.save(moradorDoCentro1);
		repositorio.save(moradorDoCentro2);
		int quantidade = repositorio.findAll().size();
		assertEquals(3, quantidade);
	}
	
	@Test
	public void atualizar() {
		MoradorDeRua moradorDoCentro = new MoradorDeRua(10.0, -10.0);
		repositorio.save(moradorDoCentro);
		moradorDoCentro.moradorEncontrado();
		repositorio.save(moradorDoCentro);
		MoradorDeRua moradorRecuperado = repositorio.findOne(moradorDoCentro.getId());
		assertTrue(moradorRecuperado.isLocalizado());
	}
	
	@Test
	public void remover() {
		MoradorDeRua moradorDoCentro = new MoradorDeRua(10.0, -10.0);
		repositorio.save(moradorDoCentro);
		repositorio.delete(moradorDoCentro);
		long quantidade = repositorio.count();
		assertEquals(0, quantidade);
	}

}
