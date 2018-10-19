package com.antawa.services;

import java.util.List;

import com.antawa.model.Position;

public interface PosService {
	/**
	 * This method find all User object's.
	 * 
	 * @return
	 */
	List<Position> findAll();

}
