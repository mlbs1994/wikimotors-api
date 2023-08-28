package com.wikimotors.api.model.automovel;

public record AutomovelUpdateDTO(
		Long id,
		String modelo,
		Categoria categoria,
		String descricao,
		int anoFabricacao,
		Tracao tracao) {
	
}
