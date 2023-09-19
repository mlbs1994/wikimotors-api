package com.wikimotors.api.model.fabricante.dtos;

import com.wikimotors.api.model.fabricante.entities.Fabricante;

public record FabricanteDetalhesDTO(String nome, String pais, String descricao, String logo_img) {
	
	public FabricanteDetalhesDTO(Fabricante fabricante) {
		this(
				fabricante.getNome() != null ? fabricante.getNome().trim() : "",
				fabricante.getPais() != null ? fabricante.getPais().trim() : "",
				fabricante.getDescricao() != null ? fabricante.getDescricao().trim() : "",
				fabricante.getLogo_img() != null ? fabricante.getLogo_img() : "");
	}
}
