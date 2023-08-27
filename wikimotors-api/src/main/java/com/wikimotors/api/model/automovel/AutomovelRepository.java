package com.wikimotors.api.model.automovel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomovelRepository extends JpaRepository<Automovel, Long>{

	Page<Automovel> findByFabricanteId(Long fabricanteId, Pageable pagination);

}
