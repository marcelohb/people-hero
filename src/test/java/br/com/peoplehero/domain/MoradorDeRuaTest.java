package br.com.peoplehero.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.peoplehero.dominio.MoradorDeRua;

public class MoradorDeRuaTest {

	@Test
	public void novoMoradorDeRua() {
		MoradorDeRua morador = new MoradorDeRua(-21.0, 30.0);
		assertEquals(Double.valueOf(-21.0), morador.getLatitude());
		assertEquals(Double.valueOf(30.0), morador.getLongitude());
	}
	
	@Test
	public void moradoresIguais() {
		MoradorDeRua moradorDoCentro = new MoradorDeRua(10.0, 10.0);
		MoradorDeRua moradorDaZonaSul = new MoradorDeRua(10.0, 10.0);
		assertEquals(moradorDoCentro, moradorDaZonaSul);
	}
	
	@Test
	public void novoMoradorNaoLocalizado() {
		MoradorDeRua moradorDoCentro = new MoradorDeRua(10.0, 10.0);
		assertFalse(moradorDoCentro.isLocalizado());
	}
	
	@Test
	public void encontrarMorador() {
		MoradorDeRua moradorDoCentro = new MoradorDeRua(10.0, 10.0);
		moradorDoCentro.moradorEncontrado();
		assertTrue(moradorDoCentro.isLocalizado());
		
	}

}
