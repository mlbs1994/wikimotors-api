package com.wikimotors.api.adapters.fabricante.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wikimotors.api.adapters.fabricante.repositories.FabricanteRepository;
import com.wikimotors.api.model.fabricante.Fabricante;
import com.wikimotors.api.model.fabricante.FabricanteDTO;
import com.wikimotors.api.model.fabricante.FabricanteDetalhesDTO;
import com.wikimotors.api.model.fabricante.FabricanteResumoDTO;
import com.wikimotors.api.model.fabricante.FabricanteUpdateDTO;
import com.wikimotors.api.ports.fabricante.FabricanteService;

@Service
public class FabricanteServiceImpl implements FabricanteService {

	private final FabricanteRepository fabricanteRepository;
	
	
	@Autowired
	public FabricanteServiceImpl(FabricanteRepository fabricanteRepository) {
		this.fabricanteRepository = fabricanteRepository;
	}
	
	@Override
	public FabricanteDTO criarFabricante(FabricanteDTO data) {
		Fabricante fabricante = new Fabricante(data);
		fabricanteRepository.save(fabricante);
		return new FabricanteDTO(fabricante);
	}

	@Override
	public Page<FabricanteDTO> listarFabricantes(Pageable pagination) {
		Page<FabricanteDTO> pageFabricantes = fabricanteRepository.findAll(pagination).map(FabricanteDTO::new);
		return pageFabricantes;
	}

	@Override
	public Page<FabricanteResumoDTO> listarFabricantesResumido(Pageable pagination) {
		Page<FabricanteResumoDTO> pageFabricantesResumido = fabricanteRepository.findAll(pagination).map(FabricanteResumoDTO::new);
		return pageFabricantesResumido;
	}

	@Override
	public FabricanteDetalhesDTO detalharFabricante(Long id) {
		Fabricante fabricante = fabricanteRepository.getReferenceById(id);
		return new FabricanteDetalhesDTO(fabricante);
	}

	@Override
	public Page<FabricanteDetalhesDTO> listarFabricantesPorPais(String pais, Pageable pagination) {
		Page<FabricanteDetalhesDTO> pageFabricantesPais = fabricanteRepository.findByPais(pais, pagination).map(FabricanteDetalhesDTO::new);
		return pageFabricantesPais;
	}

	@Override
	public Page<FabricanteDetalhesDTO> listarFabricantesPorNome(String nome, Pageable pagination) {
		Page<FabricanteDetalhesDTO> pageFabricantesNome = fabricanteRepository.findByNomeContaining(nome, pagination).map(FabricanteDetalhesDTO::new);
		return pageFabricantesNome;
	}

	@Override
	public FabricanteDetalhesDTO atualizarFabricante(FabricanteUpdateDTO data) {
		Fabricante fabricante = fabricanteRepository.getReferenceById(data.id());
		fabricante.update(data);
		return new FabricanteDetalhesDTO(fabricante);
	}

	@Override
	public void deletarFabricante(Long id) {
		fabricanteRepository.deleteById(id);
	}

}
