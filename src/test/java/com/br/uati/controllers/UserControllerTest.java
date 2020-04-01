package com.br.uati.controllers;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.br.uati.models.User;
import com.br.uati.repositories.UserRepository;
import com.br.uati.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
public class UserControllerTest {
	
	@Autowired
	private UserService userServiceMock;
	
	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;
    
    @MockBean(name = "delete")
    private UserService userServiceTest;
    
    @MockBean
    UserRepository userRepository;
    
    private static final String URL = "https://viacep.com.br/ws/";
    
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
	public void testar_find_all() {
//		List<User> listaUser =  new ArrayList<>();
//		listaUser.add(user);
//		
//		mvc.perform(get(URL).contentType(MediaType.APPLICATION_JSON).ac
		
	}
}
