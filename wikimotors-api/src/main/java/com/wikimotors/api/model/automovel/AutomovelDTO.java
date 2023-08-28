package com.wikimotors.api.model.automovel;

import com.wikimotors.api.model.fabricante.FabricanteDTO;

public record AutomovelDTO(
		FabricanteDTO fabricante,
		String modelo,
		int anoFabricacao,
		Categoria categoria,
		Tracao tracao,
		String descricao) {
	
	public AutomovelDTO(Automovel automovel) {
		this(
				new FabricanteDTO(automovel.getFabricante()),
				automovel.getModelo(),
				automovel.getAnoFabricacao(),
				automovel.getCategoria(),
				automovel.getTracao(),
				automovel.getDescricao());
	}
	
}
