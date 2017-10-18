package br.com.peoplehero.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.peoplehero.dominio.MoradorDeRua;

public interface MoradorDeRuaRepositorio extends JpaRepository<MoradorDeRua, Integer> {

}
