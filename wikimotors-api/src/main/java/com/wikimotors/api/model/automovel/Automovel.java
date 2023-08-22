package com.wikimotors.api.model.automovel;

import java.util.Date;

import com.wikimotors.api.model.fabricante.Fabricante;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="fabricante")
	@Embedded
	Fabricante fabricante;
	
	private String modelo;
	
	@Column(name="ano_fabricacao")
	private Date anoFabricacao;
	
	private String categoria;
	
	private String tracao;
	
	@Lob
	@Column(name="descricao", columnDefinition="text")
	private String descricao;
	
	
	
	
	
	
}
