package com.br.uati.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

//@RunWith(SpringRunner.class)
public class UserTest {

	private static final Integer ID = 1;
	private static final String NAME = "MY NAME";
	private static final String EMAIL = "MY EMAIL";
	private static final String CEP = "MY CEP";
	private static final String LOGRADOURO = "MY LOGRADOURO";
	private static final String COMPLEMENTO = "MY COMPLEMENTO";
	private static final String BAIRRO = "MY BAIRRO";
	private static final String LOCALIDADE = "MY LOCALIDADE";
	private static final String UF = "MY UF";
	private static final String UNIDADE = "MY UNIDADE";
	private static final String IBGE = "MY IBGE";
	private static final String GIA = "MY GIA";

	private User user;

	@Before
	public void setUp() throws Exception {
		user = new User();
		user = new User(ID, NAME, EMAIL, CEP, COMPLEMENTO, LOGRADOURO, BAIRRO, LOCALIDADE, UF, UNIDADE, IBGE, GIA);
		user.setId(ID);
		user.setName(NAME);
		user.setEmail(EMAIL);
		user.setCep(CEP);
		user.setLogradouro(LOGRADOURO);
		user.setComplemento(COMPLEMENTO);
		user.setBairro(BAIRRO);
		user.setLocalidade(LOCALIDADE);
		user.setUf(UF);
		user.setUnidade(UNIDADE);
		user.setIbge(IBGE);
		user.setGia(GIA);
	}

	@Test
	public void testar_setters_e_getters() {

		assertEquals(ID, user.getId());
		assertEquals(NAME, user.getName());
		assertEquals(EMAIL, user.getEmail());
		assertEquals(CEP, user.getCep());
		assertEquals(LOGRADOURO, user.getLogradouro());
		assertEquals(COMPLEMENTO, user.getComplemento());
		assertEquals(BAIRRO, user.getBairro());
		assertEquals(LOCALIDADE, user.getLocalidade());
		assertEquals(UF, user.getUf());
		assertEquals(UNIDADE, user.getUnidade());
		assertEquals(IBGE, user.getIbge());
		assertEquals(GIA, user.getGia());

	}

}
