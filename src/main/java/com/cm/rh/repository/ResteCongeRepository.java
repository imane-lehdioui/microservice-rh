package com.cm.rh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cm.rh.entity.Personnel;
import com.cm.rh.entity.ResteConge;
import com.cm.rh.entity.TypeConge;

public interface ResteCongeRepository extends JpaRepository<ResteConge, Long> {

	@Query("SELECT u FROM ResteConge u WHERE u.personnel = :personnel and u.type = :type")
	ResteConge findResteByPersonnelAndType(@Param("personnel") Optional<Personnel> personnel, 
	  @Param("type") Optional<TypeConge> type);


	
}
