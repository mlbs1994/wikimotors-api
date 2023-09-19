package com.wikimotors.api.ports.automovel;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wikimotors.api.model.automovel.AutomovelDTO;
import com.wikimotors.api.model.automovel.AutomovelDefaultDTO;
import com.wikimotors.api.model.automovel.AutomovelDetalhesDTO;
import com.wikimotors.api.model.automovel.AutomovelResumoDTO;
import com.wikimotors.api.model.automovel.AutomovelUpdateDTO;
import com.wikimotors.api.model.automovel.Categoria;
import com.wikimotors.api.model.automovel.Tracao;

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
