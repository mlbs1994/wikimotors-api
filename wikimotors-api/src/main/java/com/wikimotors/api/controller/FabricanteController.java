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

import com.wikimotors.api.model.fabricante.Fabricante;
import com.wikimotors.api.model.fabricante.FabricanteDTO;
import com.wikimotors.api.model.fabricante.FabricanteDetalhesDTO;
import com.wikimotors.api.model.fabricante.FabricanteRepository;
import com.wikimotors.api.model.fabricante.FabricanteResumoDTO;
import com.wikimotors.api.model.fabricante.FabricanteUpdateDTO;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("fabricantes")
public class FabricanteController {
	
	@Autowired
	FabricanteRepository fabricanteRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<FabricanteDTO> create(@RequestBody FabricanteDTO data, UriComponentsBuilder uribuilder){
		Fabricante fabricante = new Fabricante(data);
		fabricanteRepository.save(fabricante);
		
		URI uri = uribuilder.path("fabricantes/{id}").buildAndExpand(fabricante.getId()).toUri();
		
		return ResponseEntity.created(uri).body(data);
	}
	
	@GetMapping
	public ResponseEntity<Page<FabricanteDTO>> list(@PageableDefault(size = 10, sort= {"nome"}) Pageable pagination){
		Page<FabricanteDTO> page = fabricanteRepository.findAll(pagination).map(FabricanteDTO::new);
		
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/resumo")
	public ResponseEntity<Page<FabricanteResumoDTO>> resumedList(@PageableDefault(size = 10, sort= {"nome"}) Pageable pagination){
		Page<FabricanteResumoDTO> page = fabricanteRepository.findAll(pagination).map(FabricanteResumoDTO::new);
		
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FabricanteDetalhesDTO> detail(@PathVariable Long id){
		Fabricante fabricante = fabricanteRepository.getReferenceById(id);
		
		FabricanteDetalhesDTO fabricanteDetalhes = new FabricanteDetalhesDTO(fabricante);
		
		return ResponseEntity.ok(fabricanteDetalhes);
	}
	
	@GetMapping("/pais/{pais}")
	public ResponseEntity<Page<FabricanteDetalhesDTO>> obtainByPais (@PathVariable String pais, @PageableDefault(size=10, sort = {"nome"}) Pageable pagination){
		Page<FabricanteDetalhesDTO> page = fabricanteRepository.findByPais(pais, pagination).map(FabricanteDetalhesDTO::new); 
		
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Page<FabricanteDetalhesDTO>> obtainByNome (@PathVariable String nome, @PageableDefault(size=10, sort = {"nome"}) Pageable pagination){
		Page<FabricanteDetalhesDTO> page = fabricanteRepository.findByNomeContaining(nome, pagination).map(FabricanteDetalhesDTO::new);
		
		return ResponseEntity.ok(page);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<FabricanteDetalhesDTO> update(@RequestBody FabricanteUpdateDTO data){
		Fabricante fabricante = fabricanteRepository.getReferenceById(data.id());
		
		fabricante.update(data);
		
		FabricanteDetalhesDTO fabricanteDetalhes = new FabricanteDetalhesDTO(fabricante);
		
		return ResponseEntity.ok(fabricanteDetalhes);
		
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long id){
		fabricanteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
