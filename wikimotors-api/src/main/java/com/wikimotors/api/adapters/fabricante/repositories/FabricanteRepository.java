package com.wikimotors.api.adapters.fabricante.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wikimotors.api.model.fabricante.entities.Fabricante;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long>{

	Page<Fabricante> findByPais(String pais, Pageable pagination);

	Page<Fabricante> findByNomeContaining(String nome, Pageable pagination);

}
