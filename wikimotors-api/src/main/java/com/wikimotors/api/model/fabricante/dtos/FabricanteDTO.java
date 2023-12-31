package com.wikimotors.api.model.fabricante.dtos;

import com.wikimotors.api.model.fabricante.entities.Fabricante;

public record FabricanteDTO(
		Long id,
		String nome,
		String pais,
		String descricao,
		String logo_img) {

	public FabricanteDTO(Fabricante fabricante) {
		this(fabricante.getId(), fabricante.getNome(), fabricante.getPais(), fabricante.getDescricao(), fabricante.getLogo_img());
	}
}
