package com.wikimotors.api.model.automovel;

import com.wikimotors.api.model.fabricante.FabricanteDTO;

public record AutomovelDefaultDTO (
		FabricanteDTO fabricante,
		String modelo,
		int anoFabricacao,
		Categoria categoria,
		Tracao tracao,
		String descricao) {
	
	public AutomovelDefaultDTO(Automovel automovel) {
		this(
				new FabricanteDTO(automovel.getFabricante()),
				automovel.getModelo(),
				automovel.getAnoFabricacao(),
				automovel.getCategoria(),
				automovel.getTracao(),
				automovel.getDescricao());
	}
	
}
