package com.br.uati.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.br.uninassau.models.User;
import com.br.uninassau.repositories.UserRepository;
import com.br.uninassau.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
public class UserControllerTest {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;
    
    @MockBean(name = "delete")
    private UserService userServiceTest;
    
    @Mock
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
	public void testar_find_all() throws Exception {

		List<User> userList = new ArrayList<>();
        userList.add(user);
        Page<User> pageUsers = new PageImpl<>(userList);
        BDDMockito.given(userRepository.findAll(Mockito.any(Pageable.class))).willReturn(pageUsers);
        mvc.perform(get(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.[0].id").value(user.getId()))
                .andExpect(jsonPath("$.content.[0].name").value(user.getName()))
                .andExpect(jsonPath("$.content.[0].email").value(user.getEmail()))
                .andExpect(jsonPath("$.content.[0].cep").value(user.getCep()))
                .andExpect(jsonPath("$.content.[0].logradouro").value(user.getLogradouro()))
                .andExpect(jsonPath("$.content.[0].complemento").value(user.getComplemento()))
                .andExpect(jsonPath("$.content.[0].bairro").value(user.getBairro()))
                .andExpect(jsonPath("$.content.[0].localidade").value(user.getLocalidade()))
                .andExpect(jsonPath("$.content.[0].uf").value(user.getUf()))
                .andExpect(jsonPath("$.content.[0].unidade").value(user.getUnidade()))
                .andExpect(jsonPath("$.content.[0].ibge").value(user.getIbge()))
                .andExpect(jsonPath("$.content.[0].gia").value(user.getGia()));		
	}
}