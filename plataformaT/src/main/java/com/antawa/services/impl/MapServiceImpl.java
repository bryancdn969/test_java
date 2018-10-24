package com.antawa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antawa.model.Map;
import com.antawa.model.repository.MapRepository;
import com.antawa.services.MapService;

@Service
public class MapServiceImpl implements MapService{

	/**
	 * Repository of User.
	 */
	@Autowired
	private MapRepository mapRepository;
	
	@Override
	public List<Map> findAll() {
		return mapRepository.findAll();
	}
}
