package com.wikimotors.api.model.automovel.entities;


import com.wikimotors.api.model.automovel.dtos.AutomovelDefaultDTO;
import com.wikimotors.api.model.automovel.dtos.AutomovelUpdateDTO;
import com.wikimotors.api.model.fabricante.entities.Fabricante;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="Automovel")
@Table(name="automovel")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Automovel { 
	
	public Automovel(AutomovelDefaultDTO data, Fabricante fabricante) {
		this.fabricante = fabricante;
		this.modelo = data.modelo();
		this.anoFabricacao = data.anoFabricacao();
		this.categoria = data.categoria();
		this.tracao = data.tracao();
		this.descricao = data.descricao();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="fabricante")
	@Embedded
	Fabricante fabricante;
	
	private String modelo;
	
	@Column(name="ano_fabricacao")
	private int anoFabricacao;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@Enumerated(EnumType.STRING)
	private Tracao tracao;
	
	private String descricao;

	public void update(AutomovelUpdateDTO data) {
		if(data.modelo() != null && !data.modelo().equals("")) this.modelo = data.modelo();
		if((data.anoFabricacao() == 0)) this.anoFabricacao = data.anoFabricacao();
		if(data.descricao() != null && !data.descricao().equals("")) this.descricao = data.descricao();
		if(data.categoria() != null) this.categoria = data.categoria();
		if(data.tracao() != null) this.tracao = data.tracao();
	}
	
	
	
	
	
	
}
