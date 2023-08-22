package com.wikimotors.api.model.automovel;

import java.util.Date;

import com.wikimotors.api.model.fabricante.FabricanteDTO;

public record AutomovelDTO(
		FabricanteDTO fabricante,
		String modelo,
		Date anoFabricacao,
		String categoria,
		String tracao,
		String descricao) {}
