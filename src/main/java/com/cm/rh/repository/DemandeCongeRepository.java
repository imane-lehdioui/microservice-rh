package com.cm.rh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cm.rh.entity.DemandeConge;

public interface DemandeCongeRepository extends JpaRepository<DemandeConge, Long> {

	List<DemandeConge> findAllByOrderByIdDesc();

}
