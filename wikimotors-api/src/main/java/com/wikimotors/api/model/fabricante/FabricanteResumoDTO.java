package com.wikimotors.api.model.fabricante;

public record FabricanteResumoDTO(String nome, String pais) {
	
	public FabricanteResumoDTO(Fabricante fabricante) {
		this(fabricante.getNome(), fabricante.getPais());
	}
}
