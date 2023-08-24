package com.wikimotors.api.model.fabricante;

public record FabricanteUpdateDTO(Long id, String nome, String pais, String descricao, String logoImg) {
	
	public FabricanteUpdateDTO(Fabricante fabricante) {
		this(fabricante.getId(), fabricante.getNome(), fabricante.getPais(), fabricante.getDescricao(), fabricante.getLogo_img());
	}

}
