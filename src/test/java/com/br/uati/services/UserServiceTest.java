package com.br.uati.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.br.uati.dto.CepDto;
import com.br.uati.models.User;
import com.br.uati.repositories.UserRepository;

public class UserServiceTest {
	
	@InjectMocks
	UserService userService;

	@Mock
	UserRepository userRepository;
	
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
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
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
	public void testar_find_all_users() {
		List<User> listaUser= new ArrayList<>();
		listaUser.add(user);
		
		List<User> expectedUsers = Arrays.asList(user);

		doReturn(expectedUsers).when(userRepository).findAll();

		// when
		List<User> actualProducts = userService.findAll();

		// then
		assertThat(actualProducts).isEqualTo(expectedUsers);
	}
	
	@Test
	public void testar_find_by_id() {
		List<User> listaUser= new ArrayList<>();
		listaUser.add(user);

		when(userRepository.findById(ID)).thenReturn(Optional.of(user));

		User actualProducts = userService.findById(ID);

		assertThat(actualProducts).isEqualTo(user);
	}

	@Test
    public void testar_insert_user() {
        CepDto cepDto = new CepDto();
        cepDto.setCep(CEP);
        BDDMockito.given(userRepository.save(Mockito.any())).willReturn(user);
        assertEquals(user, userService.insertUsers(user));
    }
	
	@Test
    public void testar_delete_user() {
        Optional<User> optionalUser = Optional.of(user);
        BDDMockito.given(userRepository.findById(1)).willReturn(optionalUser);
        userService.deleteUser(user.getId());
        verify(userRepository, times(1)).delete(user);
    }
}