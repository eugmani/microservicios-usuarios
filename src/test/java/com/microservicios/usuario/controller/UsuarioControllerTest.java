package com.microservicios.usuario.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.MockMvc;

import com.microservicios.usuario.service.UsuarioService;

@WebMvcTest(controllers = UsuarioController.class)
class UsuarioControllerTest {
	
	@MockBean
	private UsuarioService service;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void testFindUsuarioPageable() throws Exception {
		mockMvc.perform(get("/")
		        .param("page", "5")
		        .param("size", "10")
		        .param("sort", "id,desc")   // <-- no space after comma!
		        .param("sort", "name,asc")) // <-- no space after comma!
		        .andExpect(status().isOk());
		
		ArgumentCaptor<Pageable> pageableCaptor = 
		        ArgumentCaptor.forClass(Pageable.class);
		    verify(service).find(pageableCaptor.capture(), null);
		    PageRequest pageable = (PageRequest) pageableCaptor.getValue();

//		    assertThat(pageable).hasPageNumber(5);
//		    assertThat(pageable).hasPageSize(10);
//		    assertThat(pageable).hasSort("name", Sort.Direction.ASC);
//		    assertThat(pageable).hasSort("id", Sort.Direction.DESC);
	}

}
