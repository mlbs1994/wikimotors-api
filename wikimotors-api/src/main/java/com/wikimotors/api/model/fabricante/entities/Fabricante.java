package com.wikimotors.api.model.fabricante.entities;

import com.wikimotors.api.model.fabricante.dtos.FabricanteDTO;
import com.wikimotors.api.model.fabricante.dtos.FabricanteUpdateDTO;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="Fabricante")
@Table(name="fabricante")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Embeddable
public class Fabricante {
	
	public Fabricante(FabricanteDTO data) {
		this.nome = data.nome();
		this.pais = data.pais();
		this.descricao = data.descricao();
		this.logo_img = data.logo_img(); 
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	String nome;
	
	String pais;
	
	String descricao;
	
	private String logo_img;

	public void update(FabricanteUpdateDTO data) {
		if(data.nome() != null && !data.nome().equals("")) this.nome = data.nome();
		if(data.pais() != null && !data.pais().equals("")) this.pais = data.pais();
		if(data.descricao() != null && !data.descricao().equals("")) this.descricao = data.descricao();
		if(data.logo_img() != null && !data.logo_img().equals("")) this.logo_img = data.logo_img(); 
		
	}
	
	
}
