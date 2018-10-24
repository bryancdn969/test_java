package com.antawa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antawa.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{

}
