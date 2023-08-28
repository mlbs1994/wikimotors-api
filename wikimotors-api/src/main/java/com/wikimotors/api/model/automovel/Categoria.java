package com.wikimotors.api.model.automovel;

import lombok.Getter;

@Getter
public enum Categoria {
	
	SEDAN("SEDAN - Sedan"),
	HATCHBACK("HATCHBACK - Hatchback"),
	COUPE("COUPE - Coupê"),
	CONVERSIVEL("CONVERSIVEL - Conversível"),
	PERUA("PERUA - Perua"),
	SUV("SUV"),
	CROSSOVER("CROSSOVER - Crossover"),
	MINIVAN("MINIVAN - Minivan"),
	PICAPE("PICAPE - Picape"),
	MICROCARRO("MICROCARRO - Micro carro"),
	CITY_CAR("CITY_CAR - City Car"),
	ESPORTIVO("ESPORTIVO - Esportivo"),
	SUPERESPORTIVO("SUPERESPORTIVO - Superesportivo"),
	LUXO("LUXO - Carro de Luxo"),
	CORRIDA("CORRIDA - Carro de Corrida"),
	CLASSICO("CLASSICO - Carro Clássico"),
	QUATRO_POR_QUATRO("QUATRO_POR_QUATRO - 4X4");
	
	private String descricao;
	
	Categoria(String descricao){
		this.descricao = descricao;
	}

}
