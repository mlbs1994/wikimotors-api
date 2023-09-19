package com.wikimotors.api.model.automovel.dtos;

import com.wikimotors.api.model.automovel.entities.Automovel;

public record AutomovelResumoDTO(
		String modelo,
		String fabricante,
		int anoFabricacao,
		String categoria) {
	
	public AutomovelResumoDTO(Automovel automovel) {
		this(
				automovel.getModelo(),
				automovel.getFabricante().getNome(),
				automovel.getAnoFabricacao(),
				automovel.getCategoria().getDescricao());
	}
	

}
