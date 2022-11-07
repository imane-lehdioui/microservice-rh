package com.cm.rh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cm.bein.PersonnelResponse;
import com.cm.rh.entity.Personnel;


public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

public Personnel findById(long id);
    
	public List<PersonnelResponse> findAllByOrderByIdDesc();
	
	public Personnel findByMatricule(String matricule);
	
	@Query("select new com.cm.rh.entity.Personnel(p.id ,p.matricule,p.nom, p.prenom, p.typePersonnel) from Personnel p where p.idDivision = ?1 order by p.id desc ")
	public List<PersonnelResponse> findByIdDivisionOrderByIdDesc(long idD);
	
	@Query("select new com.cm.rh.entity.Personnel(p.id ,p.matricule,p.nom, p.prenom, p.typePersonnel) from Personnel p where p.idService = ?1 order by p.id desc")
	public List<PersonnelResponse> findByIdService(long id);
	
	@Query("select new com.cm.rh.entity.Personnel(p.id ,p.matricule,p.nom, p.prenom, p.typePersonnel) from Personnel p where p.idDivision = ?1 and p.idService = ?2 order by p.id desc")
	public List<PersonnelResponse> findByIdDivisionAndIdServiceOrderByIdDesc(long idd,long ids);
	
	public List<Personnel> findByNomContaining(String filter);
	public List<Personnel> findByMatriculeContaining(String filter);
	
	@Query("select new com.cm.rh.entity.Personnel(p.id,p.nom, p.prenom, p.matricule) from Personnel p where p.id = ?1")
	PersonnelResponse findPersonnelById(long id);
	
}
