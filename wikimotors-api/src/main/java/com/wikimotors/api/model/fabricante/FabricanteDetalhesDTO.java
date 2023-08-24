package com.wikimotors.api.model.fabricante;

public record FabricanteDetalhesDTO(String nome, String pais, String descricao, String logoImg) {
	
	public FabricanteDetalhesDTO(Fabricante fabricante) {
		this(
				fabricante.getNome() != null ? fabricante.getNome().trim() : "",
				fabricante.getPais() != null ? fabricante.getPais().trim() : "",
				fabricante.getDescricao() != null ? fabricante.getDescricao().trim() : "",
				fabricante.getLogo_img() != null ? fabricante.getLogo_img() : "");
	}
}
