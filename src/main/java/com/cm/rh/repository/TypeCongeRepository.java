package com.cm.rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cm.rh.entity.TypeConge;



public interface TypeCongeRepository extends JpaRepository<TypeConge, Long> {
	
	public TypeConge findById(long id);

}
