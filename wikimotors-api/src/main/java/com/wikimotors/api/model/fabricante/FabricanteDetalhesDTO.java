package com.wikimotors.api.model.fabricante;

public record FabricanteDetalhesDTO(String nome, String pais, String descricao, String logoImg) {
	
	public FabricanteDetalhesDTO(Fabricante fabricante) {
		this(
				fabricante.getNome().trim(),
				fabricante.getPais().trim(),
				fabricante.getDescricao().trim(),
				fabricante.getLogo_img());
	}
}
