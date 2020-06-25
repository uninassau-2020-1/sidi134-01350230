package com.br.uninassau.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.uninassau.dto.DadosMunicipiosDto;
import com.br.uninassau.models.DadosMunicipios;
import com.br.uninassau.services.DadosMunicipiosService;

@RestController
@RequestMapping(value = "/dados")
public class DadosMunicipiosController {
	
	@Autowired
	private DadosMunicipiosService dadosMunicipiosService;

	@GetMapping
	public ResponseEntity<DadosMunicipiosDto> findAll() {
		DadosMunicipiosDto listaDadosMunicipios = dadosMunicipiosService.findAll();
		return ResponseEntity.ok().body(listaDadosMunicipios);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DadosMunicipios> findById(@PathVariable Integer id){
		DadosMunicipios objDadosMunicipios = dadosMunicipiosService.findById(id);
		return ResponseEntity.ok().body(objDadosMunicipios);
	}
	
}
