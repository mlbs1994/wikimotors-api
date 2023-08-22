package com.wikimotors.api.model.automovel;

import com.wikimotors.api.model.fabricante.FabricanteDTO;

public record AutomovelDTO(
		FabricanteDTO fabricante,
		String modelo,
		int anoFabricacao,
		String categoria,
		String tracao,
		String descricao) {}
