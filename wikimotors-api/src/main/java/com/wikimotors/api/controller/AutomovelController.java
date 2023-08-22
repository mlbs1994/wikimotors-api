package com.wikimotors.api.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wikimotors.api.model.automovel.AutomovelDTO;
import com.wikimotors.api.model.automovel.AutomovelRepository;
import com.wikimotors.api.model.fabricante.Fabricante;
import com.wikimotors.api.model.fabricante.FabricanteDTO;
import com.wikimotors.api.model.fabricante.FabricanteRepository;
import com.wikimotors.api.model.automovel.Automovel;


import jakarta.transaction.Transactional;

@RestController
@RequestMapping("automoveis")
public class AutomovelController {
	
	@Autowired
	AutomovelRepository automovelRepository;
	
	@Autowired
	FabricanteRepository fabricanteRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<AutomovelDTO> create(@RequestBody AutomovelDTO data, UriComponentsBuilder uribuilder){
		
		Fabricante fabricante = fabricanteRepository.getReferenceById(data.fabricante().id());
		
		Automovel automovel = new Automovel(data, fabricante);
		automovelRepository.save(automovel);
		
		URI uri = uribuilder.path("automoveis/{id}").buildAndExpand(automovel.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new AutomovelDTO(
				new FabricanteDTO(fabricante),
				automovel.getModelo(),
				automovel.getAnoFabricacao(),
				automovel.getCategoria(),
				automovel.getTracao(),
				automovel.getDescricao()));
	}
	
	
}
