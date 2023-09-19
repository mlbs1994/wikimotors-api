package com.wikimotors.api.ports.fabricante;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.wikimotors.api.model.fabricante.FabricanteDTO;
import com.wikimotors.api.model.fabricante.FabricanteDetalhesDTO;
import com.wikimotors.api.model.fabricante.FabricanteResumoDTO;
import com.wikimotors.api.model.fabricante.FabricanteUpdateDTO;

public interface FabricanteServicePort {

	public ResponseEntity<FabricanteDTO> create(FabricanteDTO data, UriComponentsBuilder uribuilder);

	public ResponseEntity<Page<FabricanteDTO>> list(Pageable pagination);

	public ResponseEntity<Page<FabricanteResumoDTO>> resumedList(Pageable pagination);

	public ResponseEntity<FabricanteDetalhesDTO> detail(Long id);

	public ResponseEntity<Page<FabricanteDetalhesDTO>> obtainByPais(String pais, Pageable pagination);

	public ResponseEntity<Page<FabricanteDetalhesDTO>> obtainByNome(String nome, Pageable pagination);

	public ResponseEntity<FabricanteDetalhesDTO> update(FabricanteUpdateDTO data);

	public ResponseEntity<Void> delete(Long id);

}
