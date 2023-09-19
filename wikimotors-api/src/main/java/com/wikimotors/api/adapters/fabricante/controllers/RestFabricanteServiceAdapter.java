package com.wikimotors.api.adapters.fabricante.controllers;

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

import com.wikimotors.api.model.fabricante.dtos.FabricanteDTO;
import com.wikimotors.api.model.fabricante.dtos.FabricanteDetalhesDTO;
import com.wikimotors.api.model.fabricante.dtos.FabricanteResumoDTO;
import com.wikimotors.api.model.fabricante.dtos.FabricanteUpdateDTO;
import com.wikimotors.api.ports.fabricante.FabricanteService;
import com.wikimotors.api.ports.fabricante.FabricanteServicePort;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("fabricantes")
public class RestFabricanteServiceAdapter implements FabricanteServicePort {
	
	private final FabricanteService fabricanteService;
	
	@Autowired
	public RestFabricanteServiceAdapter(FabricanteService fabricanteService) {
		this.fabricanteService = fabricanteService;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<FabricanteDTO> create(@RequestBody FabricanteDTO data, UriComponentsBuilder uribuilder){
		FabricanteDTO fabricanteDTO = fabricanteService.criarFabricante(data);
		URI uri = uribuilder.path("fabricantes/{id}").buildAndExpand(fabricanteDTO.id()).toUri();
		return ResponseEntity.created(uri).body(data);
	}
	
	@GetMapping
	public ResponseEntity<Page<FabricanteDTO>> list(@PageableDefault(size = 10, sort= {"nome"}) Pageable pagination){
		Page<FabricanteDTO> page = fabricanteService.listarFabricantes(pagination);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/resumo")
	public ResponseEntity<Page<FabricanteResumoDTO>> resumedList(@PageableDefault(size = 10, sort= {"nome"}) Pageable pagination){
		Page<FabricanteResumoDTO> page = fabricanteService.listarFabricantesResumido(pagination);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FabricanteDetalhesDTO> detail(@PathVariable Long id){
		FabricanteDetalhesDTO fabricanteDetalhes = fabricanteService.detalharFabricante(id);
		return ResponseEntity.ok(fabricanteDetalhes);
	}
	
	@GetMapping("/pais/{pais}")
	public ResponseEntity<Page<FabricanteDetalhesDTO>> obtainByPais (@PathVariable String pais, @PageableDefault(size=10, sort = {"nome"}) Pageable pagination){
		Page<FabricanteDetalhesDTO> page = fabricanteService.listarFabricantesPorPais(pais, pagination) ;
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Page<FabricanteDetalhesDTO>> obtainByNome (@PathVariable String nome, @PageableDefault(size=10, sort = {"nome"}) Pageable pagination){
		Page<FabricanteDetalhesDTO> page = fabricanteService.listarFabricantesPorNome(nome, pagination);
		
		return ResponseEntity.ok(page);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<FabricanteDetalhesDTO> update(@RequestBody FabricanteUpdateDTO data){
		FabricanteDetalhesDTO fabricanteDetalhes = fabricanteService.atualizarFabricante(data);
		return ResponseEntity.ok(fabricanteDetalhes);
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long id){
		fabricanteService.deletarFabricante(id);
		return ResponseEntity.noContent().build();
	}

}
