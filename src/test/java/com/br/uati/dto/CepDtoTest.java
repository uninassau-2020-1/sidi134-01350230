package com.br.uati.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.br.uninassau.dto.CepDto;

public class CepDtoTest {
	
	private static final String CEP = "MY CEP";
	private static final String LOGRADOURO = "MY LOGRADOURO";
	private static final String COMPLEMENTO = "MY COMPLEMENTO";
	private static final String BAIRRO = "MY BAIRRO";
	private static final String LOCALIDADE = "MY LOCALIDADE";
	private static final String UF = "MY UF";
	private static final String UNIDADE = "MY UNIDADE";
	private static final String IBGE = "MY IBGE";
	private static final String GIA = "MY GIA";
	
	private CepDto cepDto;
	
	@Before
	public void setUp() throws Exception {
		cepDto = new CepDto();
		cepDto = new CepDto(CEP, COMPLEMENTO, LOGRADOURO, BAIRRO, LOCALIDADE, UF, UNIDADE, IBGE, GIA);
		cepDto.setCep(CEP);
		cepDto.setLogradouro(LOGRADOURO);
		cepDto.setComplemento(COMPLEMENTO);
		cepDto.setBairro(BAIRRO);
		cepDto.setLocalidade(LOCALIDADE);
		cepDto.setUf(UF);
		cepDto.setUnidade(UNIDADE);
		cepDto.setIbge(IBGE);
		cepDto.setGia(GIA);
	}
	
	@Test
	public void testar_setters_e_getters() {

		assertEquals(CEP, cepDto.getCep());
		assertEquals(LOGRADOURO, cepDto.getLogradouro());
		assertEquals(COMPLEMENTO, cepDto.getComplemento());
		assertEquals(BAIRRO, cepDto.getBairro());
		assertEquals(LOCALIDADE, cepDto.getLocalidade());
		assertEquals(UF, cepDto.getUf());
		assertEquals(UNIDADE, cepDto.getUnidade());
		assertEquals(IBGE, cepDto.getIbge());
		assertEquals(GIA, cepDto.getGia());

	}
}