package com.wikimotors.api.model.fabricante;

public record FabricanteUpdateDTO(Long id, String nome, String pais, String descricao, String logo_img) {
	
	public FabricanteUpdateDTO(Fabricante fabricante) {
		this(
				fabricante.getId(),
				fabricante.getNome() != null ? fabricante.getNome() : "",
				fabricante.getPais() != null ? fabricante.getPais() : "",
				fabricante.getDescricao() != null ? fabricante.getDescricao(): "",
				fabricante.getLogo_img() != null ? fabricante.getLogo_img(): ""
			);
	}

}
