package com.wikimotors.api.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wikimotors.api.model.fabricante.Fabricante;
import com.wikimotors.api.model.fabricante.FabricanteDTO;
import com.wikimotors.api.model.fabricante.FabricanteRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("fabricantes")
public class FabricanteController {
	
	@Autowired
	FabricanteRepository fabriicanteRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<FabricanteDTO> create(@RequestBody FabricanteDTO data, UriComponentsBuilder uribuilder){
		Fabricante fabricante = new Fabricante(data);
		fabriicanteRepository.save(fabricante);
		
		URI uri = uribuilder.path("fabricantes/{id}").buildAndExpand(fabricante.getId()).toUri();
		
		return ResponseEntity.created(uri).body(data);
	}

}
