package com.wikimotors.api.model.automovel;

import com.wikimotors.api.model.fabricante.FabricanteResumoDTO;

public record AutomovelResumoDTO(
		FabricanteResumoDTO fabricante,
		String modelo,
		int anoFabricacao,
		String categoria) {
	
	public AutomovelResumoDTO(Automovel automovel) {
		this(
				new FabricanteResumoDTO(automovel.getFabricante()),
				automovel.getModelo(),
				automovel.getAnoFabricacao(),
				automovel.getCategoria().getDescricao());
	}
	

}
