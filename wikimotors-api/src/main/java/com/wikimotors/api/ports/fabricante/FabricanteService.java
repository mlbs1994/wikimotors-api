package com.wikimotors.api.ports.fabricante;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wikimotors.api.model.fabricante.dtos.FabricanteDTO;
import com.wikimotors.api.model.fabricante.dtos.FabricanteDetalhesDTO;
import com.wikimotors.api.model.fabricante.dtos.FabricanteResumoDTO;
import com.wikimotors.api.model.fabricante.dtos.FabricanteUpdateDTO;

public interface FabricanteService {
	
	public FabricanteDTO criarFabricante(FabricanteDTO data);
	public Page<FabricanteDTO> listarFabricantes(Pageable pagination);
	public Page<FabricanteResumoDTO> listarFabricantesResumido(Pageable pagination);
	public FabricanteDetalhesDTO detalharFabricante(Long id);
	public Page<FabricanteDetalhesDTO> listarFabricantesPorPais(String pais, Pageable pagination);
	public Page<FabricanteDetalhesDTO> listarFabricantesPorNome(String nome, Pageable pagination);
	public FabricanteDetalhesDTO atualizarFabricante(FabricanteUpdateDTO data);
	public void deletarFabricante(Long id);
	
}
