package com.wikimotors.api.model.automovel.dtos;

import com.wikimotors.api.model.automovel.entities.Categoria;
import com.wikimotors.api.model.automovel.entities.Tracao;

public record AutomovelUpdateDTO(
		Long id,
		String modelo,
		Categoria categoria,
		String descricao,
		int anoFabricacao,
		Tracao tracao) {
	
}
