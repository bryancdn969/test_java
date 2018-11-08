package com.antawa.model.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.antawa.model.CatalogGenderAndFrom;

@Repository
public interface CatalogGenderAndFromRepository extends JpaRepository<CatalogGenderAndFrom, Long>{

	List<CatalogGenderAndFrom> findAll();
	
	/**
	 * 
	 * @param id_father
	 * @return gender
	 */
	@Query("SELECT id, name FROM CatalogGenderAndFrom WHERE id_father=:idfather")
	List<CatalogGenderAndFrom> findGenderByIdFather(@Param("idfather") Long idfather);
	
	/**
	 * 
	 * @param id_father
	 * @return from
	 */
	@Query("SELECT id, name FROM CatalogGenderAndFrom WHERE id_father=:idfather")
	List<CatalogGenderAndFrom> findFromByIdFather(@Param("idfather") Long idfather);
}
