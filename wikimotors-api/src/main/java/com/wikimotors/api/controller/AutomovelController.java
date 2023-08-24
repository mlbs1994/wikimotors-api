package com.wikimotors.api.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wikimotors.api.model.automovel.AutomovelDTO;
import com.wikimotors.api.model.automovel.AutomovelDetalhesDTO;
import com.wikimotors.api.model.automovel.AutomovelRepository;
import com.wikimotors.api.model.automovel.AutomovelResumoDTO;
import com.wikimotors.api.model.automovel.AutomovelUpdateDTO;
import com.wikimotors.api.model.fabricante.Fabricante;
import com.wikimotors.api.model.fabricante.FabricanteRepository;
import com.wikimotors.api.model.fabricante.FabricanteResumoDTO;
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
	public ResponseEntity<AutomovelResumoDTO> create(@RequestBody AutomovelDTO data, UriComponentsBuilder uribuilder){
		
		Fabricante fabricante = fabricanteRepository.getReferenceById(data.fabricante().id());
		
		Automovel automovel = new Automovel(data, fabricante);
		automovelRepository.save(automovel);
		
		URI uri = uribuilder.path("automoveis/{id}").buildAndExpand(automovel.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new AutomovelResumoDTO(
				new FabricanteResumoDTO(fabricante.getNome(), fabricante.getPais()),
				automovel.getModelo(),
				automovel.getAnoFabricacao(),
				automovel.getCategoria()));
	}
	
	@GetMapping
	public ResponseEntity<Page<AutomovelDTO>> list(@PageableDefault(size = 10, sort= {"modelo"}) Pageable pagination){
		Page<AutomovelDTO> page = automovelRepository.findAll(pagination).map(AutomovelDTO::new);
		
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/resumo")
	public ResponseEntity<Page<AutomovelResumoDTO>> resumedList(@PageableDefault(size = 10, sort= {"modelo"}) Pageable pagination){
		Page<AutomovelResumoDTO> page = automovelRepository.findAll(pagination).map(AutomovelResumoDTO::new);
		
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AutomovelDetalhesDTO> detail(@PathVariable Long id){
		Automovel automovel = automovelRepository.getReferenceById(id);
		
		AutomovelDetalhesDTO automovelDetalhes = new AutomovelDetalhesDTO(automovel);
		
		return ResponseEntity.ok(automovelDetalhes);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<AutomovelDetalhesDTO> update(@RequestBody AutomovelUpdateDTO data){
		Automovel automovel = automovelRepository.getReferenceById(data.id());
		
		automovel.update(data);
		
		AutomovelDetalhesDTO automovelDetalhes = new AutomovelDetalhesDTO(automovel);
		
		return ResponseEntity.ok(automovelDetalhes);
		
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long id){
		automovelRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
