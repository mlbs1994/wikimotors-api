package com.wikimotors.api.adapters.automovel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wikimotors.api.adapters.automovel.repositories.AutomovelRepository;
import com.wikimotors.api.adapters.fabricante.repositories.FabricanteRepository;
import com.wikimotors.api.model.automovel.dtos.AutomovelDTO;
import com.wikimotors.api.model.automovel.dtos.AutomovelDefaultDTO;
import com.wikimotors.api.model.automovel.dtos.AutomovelDetalhesDTO;
import com.wikimotors.api.model.automovel.dtos.AutomovelResumoDTO;
import com.wikimotors.api.model.automovel.dtos.AutomovelUpdateDTO;
import com.wikimotors.api.model.automovel.entities.Automovel;
import com.wikimotors.api.model.automovel.entities.Categoria;
import com.wikimotors.api.model.automovel.entities.Tracao;
import com.wikimotors.api.model.fabricante.entities.Fabricante;
import com.wikimotors.api.ports.automovel.AutomovelService;


@Service
public class AutomovelServiceImpl implements AutomovelService {
	
	private final AutomovelRepository automovelRepository;
	private final FabricanteRepository fabricanteRepository;
	
	@Autowired
	public AutomovelServiceImpl(AutomovelRepository automovelRepository, FabricanteRepository fabricanteRepository) {
		this.automovelRepository = automovelRepository;
		this.fabricanteRepository = fabricanteRepository;
	}

	@Override
	public AutomovelDTO criarAutomovel(AutomovelDefaultDTO data) {
		Fabricante fabricante = fabricanteRepository.
				getReferenceById(data.fabricante().id());
				
		Automovel automovel = new Automovel(data, fabricante);
		automovelRepository.save(automovel);
		
		return new AutomovelDTO(automovel);
	}

	@Override
	public Page<AutomovelDetalhesDTO> listarAutomoveis(Pageable pagination) {
		Page<AutomovelDetalhesDTO> pageAutomoveis = automovelRepository.
				findAll(pagination).map(AutomovelDetalhesDTO::new);
		return pageAutomoveis;
	}

	@Override
	public Page<AutomovelResumoDTO> listarAutomoveisResumido(Pageable pagination) {
		Page<AutomovelResumoDTO> pageAutomoveisResumido = automovelRepository.
				findAll(pagination).map(AutomovelResumoDTO::new);
		return pageAutomoveisResumido;
	}

	@Override
	public AutomovelDetalhesDTO detalharAutomovel(Long id) {
		Automovel automovel = automovelRepository.
				getReferenceById(id);
		AutomovelDetalhesDTO automovelDetalhes = new AutomovelDetalhesDTO(automovel);
		return automovelDetalhes;
	}

	@Override
	public Page<AutomovelDetalhesDTO> obterAutomoveisPorFabricante(Long idFabricante, Pageable pagination) {
		Page<AutomovelDetalhesDTO> pageAutomoveisFabricante = automovelRepository.
				findByFabricanteId(idFabricante, pagination).map(AutomovelDetalhesDTO::new);
		return pageAutomoveisFabricante;
	}

	@Override
	public Page<AutomovelDetalhesDTO> obterAutomoveisPorTracao(Tracao tracao, Pageable pagination) {
		Page<AutomovelDetalhesDTO> pageAutomoveisTracao = automovelRepository.
				findByTracao(tracao, pagination).map(AutomovelDetalhesDTO::new);
		return pageAutomoveisTracao;
	}

	@Override
	public Page<AutomovelDetalhesDTO> obterAutomoveisPorCategoria(Categoria categoria, Pageable pagination) {
		Page<AutomovelDetalhesDTO> pageAutomoveisCategoria = automovelRepository.findByCategoria(categoria, pagination).map(AutomovelDetalhesDTO::new);
		return pageAutomoveisCategoria;
	}

	@Override
	public Page<AutomovelDetalhesDTO> obterAutomoveisPorModelo(String modelo, Pageable pagination) {
		Page<AutomovelDetalhesDTO> pageAutomoveisModelo = automovelRepository.findByModeloContaining(modelo, pagination).map(AutomovelDetalhesDTO::new);
		return pageAutomoveisModelo;
	}

	@Override
	public AutomovelDetalhesDTO atualizarAutomovel(AutomovelUpdateDTO data) {
		Automovel automovel = automovelRepository.getReferenceById(data.id());
		automovel.update(data);
		AutomovelDetalhesDTO automovelDetalhes = new AutomovelDetalhesDTO(automovel);
		return automovelDetalhes;
	}

	@Override
	public void deletarAutomovel(Long id) {
		automovelRepository.deleteById(id);
	}

	

}
