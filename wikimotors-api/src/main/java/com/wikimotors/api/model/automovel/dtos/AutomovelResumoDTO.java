package com.wikimotors.api.model.automovel.dtos;

import com.wikimotors.api.model.automovel.entities.Automovel;
import com.wikimotors.api.model.fabricante.dtos.FabricanteResumoDTO;

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
