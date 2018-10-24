package com.antawa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antawa.model.Position;
import com.antawa.model.repository.PositionRepository;
import com.antawa.services.PosService;


@Service
public class PosServiceImpl implements PosService{
	
	/**
	 * Repository of User.
	 */
	@Autowired
	private PositionRepository posRepository;
	
	@Override
	public List<Position> findAll() {
		return posRepository.findAll();
	}

}
