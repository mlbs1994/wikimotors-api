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
				automovel.getModelo(),
				automovel.getCategoria(),
				automovel.getDescricao(),
				automovel.getAnoFabricacao(),
				automovel.getTracao());
	}
	
}
