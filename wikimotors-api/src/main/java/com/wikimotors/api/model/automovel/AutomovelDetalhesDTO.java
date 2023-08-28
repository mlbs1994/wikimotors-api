package com.wikimotors.api.model.automovel;

import com.wikimotors.api.model.fabricante.FabricanteDetalhesDTO;

public record AutomovelDetalhesDTO(
		FabricanteDetalhesDTO fabricante,
		String modelo,
		String categoria,
		String descricao,
		int anoFabricacao,
		String tracao) {
	
	public AutomovelDetalhesDTO(Automovel automovel) {
		this(
				new FabricanteDetalhesDTO(automovel.getFabricante()),
				automovel.getModelo().trim(),
				automovel.getCategoria().getDescricao(),
				automovel.getDescricao().trim(),
				automovel.getAnoFabricacao(),
				automovel.getTracao().getDescricao());
	}
	
}
