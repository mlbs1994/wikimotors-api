package com.wikimotors.api.model.fabricante;

public record FabricanteDetalhesDTO(String nome, String pais, String descricao, String logoImg) {
	
	public FabricanteDetalhesDTO(Fabricante fabricante) {
		this(fabricante.getNome(), fabricante.getPais(), fabricante.getDescricao(), fabricante.getLogo_img());
	}
}
