package com.wikimotors.api.ports.automovel;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wikimotors.api.model.automovel.dtos.AutomovelDTO;
import com.wikimotors.api.model.automovel.dtos.AutomovelDefaultDTO;
import com.wikimotors.api.model.automovel.dtos.AutomovelDetalhesDTO;
import com.wikimotors.api.model.automovel.dtos.AutomovelResumoDTO;
import com.wikimotors.api.model.automovel.dtos.AutomovelUpdateDTO;
import com.wikimotors.api.model.automovel.entities.Categoria;
import com.wikimotors.api.model.automovel.entities.Tracao;

public interface AutomovelService {
	public AutomovelDTO criarAutomovel(AutomovelDefaultDTO data);
	public Page<AutomovelDetalhesDTO> listarAutomoveis(Pageable pagination);
	public Page<AutomovelResumoDTO> listarAutomoveisResumido(Pageable pagination);
	public AutomovelDetalhesDTO detalharAutomovel(Long id);
	public Page<AutomovelDetalhesDTO> obterAutomoveisPorFabricante (Long idFabricante, Pageable pagination);
	public Page<AutomovelDetalhesDTO> obterAutomoveisPorTracao (Tracao tracao, Pageable pagination);
	public Page<AutomovelDetalhesDTO> obterAutomoveisPorCategoria (Categoria categoria, Pageable pagination);
	public Page<AutomovelDetalhesDTO> obterAutomoveisPorModelo (String modelo, Pageable pagination);
	public AutomovelDetalhesDTO atualizarAutomovel(AutomovelUpdateDTO data);
	public void deletarAutomovel(Long id);
}
