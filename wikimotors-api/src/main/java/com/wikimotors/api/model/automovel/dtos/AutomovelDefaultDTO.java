package com.wikimotors.api.model.automovel.dtos;

import com.wikimotors.api.model.automovel.entities.Automovel;
import com.wikimotors.api.model.automovel.entities.Categoria;
import com.wikimotors.api.model.automovel.entities.Tracao;
import com.wikimotors.api.model.fabricante.dtos.FabricanteDTO;

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
