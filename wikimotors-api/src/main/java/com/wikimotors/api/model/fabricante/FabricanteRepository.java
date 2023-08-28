package com.wikimotors.api.model.fabricante;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long>{

	Page<Fabricante> findByPais(String pais, Pageable pagination);

	Page<Fabricante> findByNomeContaining(String nome, Pageable pagination);

}
