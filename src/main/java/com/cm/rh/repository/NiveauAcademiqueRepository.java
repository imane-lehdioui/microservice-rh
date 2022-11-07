package com.cm.rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.rh.entity.NiveauAcademique;

@Repository
public interface NiveauAcademiqueRepository extends JpaRepository<NiveauAcademique, Long> {

}
