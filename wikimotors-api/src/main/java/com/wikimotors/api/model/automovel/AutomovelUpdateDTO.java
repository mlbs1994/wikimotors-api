package com.wikimotors.api.model.automovel;

public record AutomovelUpdateDTO(
		Long id,
		String modelo,
		String categoria,
		String descricao,
		int anoFabricacao,
		String tracao) {
	
}
