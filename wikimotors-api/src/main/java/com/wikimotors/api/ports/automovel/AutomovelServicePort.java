package com.wikimotors.api.ports.automovel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.wikimotors.api.model.automovel.AutomovelDTO;
import com.wikimotors.api.model.automovel.AutomovelDefaultDTO;
import com.wikimotors.api.model.automovel.AutomovelDetalhesDTO;
import com.wikimotors.api.model.automovel.AutomovelResumoDTO;
import com.wikimotors.api.model.automovel.AutomovelUpdateDTO;
import com.wikimotors.api.model.automovel.Categoria;
import com.wikimotors.api.model.automovel.Tracao;

public interface AutomovelServicePort {
	public ResponseEntity<AutomovelDTO> create(AutomovelDefaultDTO data, UriComponentsBuilder uribuilder);
	public ResponseEntity<Page<AutomovelDetalhesDTO>> list(Pageable pagination);
	public ResponseEntity<Page<AutomovelResumoDTO>> resumedList(Pageable pagination);
	public ResponseEntity<AutomovelDetalhesDTO> detail(Long id );
	public ResponseEntity<Page<AutomovelDetalhesDTO>> obtainByManufacter (Long id, Pageable pagination);
	public ResponseEntity<Page<AutomovelDetalhesDTO>> obtainByTraction (Tracao tracao, Pageable pagination);
	public ResponseEntity<Page<AutomovelDetalhesDTO>> obtainByCategory (Categoria categoria, Pageable pagination);
	public ResponseEntity<Page<AutomovelDetalhesDTO>> obtainByModelo (String modelo, Pageable pagination);
	public ResponseEntity<AutomovelDetalhesDTO> update(AutomovelUpdateDTO data);
	public ResponseEntity<Void> delete(Long id);
}
