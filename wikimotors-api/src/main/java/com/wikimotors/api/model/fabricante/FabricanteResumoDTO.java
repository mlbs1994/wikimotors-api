package com.wikimotors.api.model.fabricante;

public record FabricanteResumoDTO(String nome, String logo_img) {
	
	public FabricanteResumoDTO(Fabricante fabricante) {
		this(fabricante.getNome(), fabricante.getLogo_img());
	}
}
