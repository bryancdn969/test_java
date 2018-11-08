package com.antawa.services;

import java.util.List;

import com.antawa.model.CatalogGenderAndFrom;

public interface CatalogGenderFromService {

	List<CatalogGenderAndFrom> findAll();
	
	/**
	 * 
	 * @param idfather
	 * @return gender
	 */
	List<CatalogGenderAndFrom> findGenderFromByIdFather(Long idfather);
	
	/**
	 * 
	 * @param idfather
	 * @return from
	 */
	List<CatalogGenderAndFrom> findFromByIdFather(Long idfather);
}
