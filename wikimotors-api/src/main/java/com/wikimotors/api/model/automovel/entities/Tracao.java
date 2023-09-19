package com.wikimotors.api.model.automovel.entities;

import lombok.Getter;

@Getter
public enum Tracao {
	
	FWD("FWD - Dianteira"),
	RWD("RWD - Traseira"),
    FOUR_WD("FOUR_WD - 4WD Quatro Rodas"),
    AWD("AWD - Integral"); 
	
	private String descricao;
	
	Tracao(String descricao){
		this.descricao = descricao;
	}
		
}
