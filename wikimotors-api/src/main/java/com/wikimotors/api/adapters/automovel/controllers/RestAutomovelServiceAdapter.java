package com.wikimotors.api.adapters.automovel.controllers;

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

import com.wikimotors.api.model.automovel.dtos.AutomovelDTO;
import com.wikimotors.api.model.automovel.dtos.AutomovelDefaultDTO;
import com.wikimotors.api.model.automovel.dtos.AutomovelDetalhesDTO;
import com.wikimotors.api.model.automovel.dtos.AutomovelResumoDTO;
import com.wikimotors.api.model.automovel.dtos.AutomovelUpdateDTO;
import com.wikimotors.api.model.automovel.entities.Categoria;
import com.wikimotors.api.model.automovel.entities.Tracao;
import com.wikimotors.api.ports.automovel.AutomovelService;
import com.wikimotors.api.ports.automovel.AutomovelServicePort;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("automoveis")
public class RestAutomovelServiceAdapter implements AutomovelServicePort {
	
	private final AutomovelService automovelService;
	
	@Autowired
	public RestAutomovelServiceAdapter(AutomovelService automovelService) {
		this.automovelService = automovelService;
	}
	
	@PostMapping
	@Transactional
	@Override
	public ResponseEntity<AutomovelDTO> create(@RequestBody AutomovelDefaultDTO data, UriComponentsBuilder uribuilder){
		AutomovelDTO automovelDTO = automovelService.criarAutomovel(data);
		URI uri = uribuilder.path("automoveis/{id}").buildAndExpand(automovelDTO.id()).toUri();
		return ResponseEntity.created(uri).body(automovelDTO);
	}
	
	@GetMapping
	public ResponseEntity<Page<AutomovelDetalhesDTO>> list(@PageableDefault(size = 10, sort= {"modelo"}) Pageable pagination){
		Page<AutomovelDetalhesDTO> page = automovelService.listarAutomoveis(pagination);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/resumo")
	public ResponseEntity<Page<AutomovelResumoDTO>> resumedList(@PageableDefault(size = 10, sort= {"modelo"}) Pageable pagination){
		Page<AutomovelResumoDTO> page = automovelService.listarAutomoveisResumido(pagination);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AutomovelDetalhesDTO> detail(@PathVariable Long id){
		AutomovelDetalhesDTO automovelDetalhes = automovelService.detalharAutomovel(id);
		return ResponseEntity.ok(automovelDetalhes);
	}
	
	@GetMapping("/fabricante/{idFabricante}")
	public ResponseEntity<Page<AutomovelDetalhesDTO>> obtainByManufacter (@PathVariable Long idFabricante, @PageableDefault(size=10, sort = {"modelo"}) Pageable pagination){
		Page<AutomovelDetalhesDTO> page = automovelService.obterAutomoveisPorFabricante(idFabricante, pagination);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/tracao/{tracao}")
	public ResponseEntity<Page<AutomovelDetalhesDTO>> obtainByTraction (@PathVariable Tracao tracao, @PageableDefault(size=10, sort = {"modelo"}) Pageable pagination){
		Page<AutomovelDetalhesDTO> page = automovelService.obterAutomoveisPorTracao(tracao, pagination);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<Page<AutomovelDetalhesDTO>> obtainByCategory (@PathVariable Categoria categoria, @PageableDefault(size=10, sort = {"modelo"}) Pageable pagination){
		Page<AutomovelDetalhesDTO> page = automovelService.obterAutomoveisPorCategoria(categoria, pagination);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/modelo/{modelo}")
	public ResponseEntity<Page<AutomovelDetalhesDTO>> obtainByModelo (@PathVariable String modelo, @PageableDefault(size=10, sort = {"modelo"}) Pageable pagination){
		Page<AutomovelDetalhesDTO> page = automovelService.obterAutomoveisPorModelo(modelo, pagination);
		return ResponseEntity.ok(page);
	}
	
	
	@PutMapping
	@Transactional
	public ResponseEntity<AutomovelDetalhesDTO> update(@RequestBody AutomovelUpdateDTO data){
		AutomovelDetalhesDTO automovelDetalhes = automovelService.atualizarAutomovel(data);
		return ResponseEntity.ok(automovelDetalhes);
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long id){
		automovelService.deletarAutomovel(id);
		return ResponseEntity.noContent().build();
	}
	
	

	
}
