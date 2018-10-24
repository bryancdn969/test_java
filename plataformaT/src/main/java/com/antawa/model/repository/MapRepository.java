package com.antawa.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antawa.model.Map;

@Repository
public interface MapRepository extends JpaRepository<Map, Long>{

	List<Map> findAll();
}
