package com.antawa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antawa.model.CatalogGenderAndFrom;
import com.antawa.model.repository.CatalogGenderAndFromRepository;
import com.antawa.services.CatalogGenderFromService;

@Service
public class CatalogGenderAndFromServiceImpl implements CatalogGenderFromService{

	/**
	 * Repository of User.
	 */
	@Autowired
	private CatalogGenderAndFromRepository catalogGFRepository;
	
	@Override
	public List<CatalogGenderAndFrom> findAll() {
		return catalogGFRepository.findAll();
	}
	
	@Override
	public List<CatalogGenderAndFrom> findGenderFromByIdFather(Long idfather) {
		return catalogGFRepository.findGenderByIdFather(idfather);
	}
	
	@Override
	public List<CatalogGenderAndFrom> findFromByIdFather(Long idfather) {
		return catalogGFRepository.findGenderByIdFather(idfather);
	}
}
