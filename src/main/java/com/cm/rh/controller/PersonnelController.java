package com.cm.rh.controller;


import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cm.bein.PersonnelResponse;
import com.cm.rh.entity.Personnel;
import com.cm.rh.entity.ResteConge;
import com.cm.rh.entity.TypeConge;
import com.cm.rh.exception.ResourceNotFoundException;
import com.cm.rh.repository.PersonnelRepository;
import com.cm.rh.repository.ResteCongeRepository;
import com.cm.rh.repository.TypeCongeRepository;




@RestController
public class PersonnelController {
	
	@Autowired
	private PersonnelRepository personnelRepository;
	@Autowired
	private ResteCongeRepository resteCongeRepository;
	
	@Autowired
	private TypeCongeRepository typeCongeRepository;
	
	/*
	 * @GetMapping("/personnels/index") public List<Personnel> getAllPersonnels() {
	 * return personnelRepository.findAllByOrderByIdDesc(); }
	 */
	@PostMapping("/personnels/index")
	
	public List<PersonnelResponse> getAllPersonnels(@RequestBody List<Long> liste){
		if(liste.get(0)== 1)
			return personnelRepository.findAllByOrderByIdDesc();
		else {
		if(liste.get(0)==0 && liste.get(1) ==0)
				return personnelRepository.findAllByOrderByIdDesc();
					else if(liste.get(1) ==0)
							return personnelRepository.findByIdDivisionOrderByIdDesc(liste.get(0));
					     else					    	 
		                       return personnelRepository.findByIdDivisionAndIdServiceOrderByIdDesc(liste.get(0),liste.get(1));
	}
	}
	
	@GetMapping("/personnels/show/{id}")
    public ResponseEntity<Personnel> findPersonnelById(@PathVariable(value = "id") Long personnelId)
        throws ResourceNotFoundException {
        Personnel personnel = personnelRepository.findById(personnelId)
          .orElseThrow(() -> new ResourceNotFoundException("personnel not found for this id :: " + personnelId));
        return ResponseEntity.ok().body(personnel);
    }
		
	@PostMapping("/personnels/new")
	public Personnel createPersonnel(@Valid @RequestBody Personnel personnel) {
		
		Personnel personnelSave = personnelRepository.save(personnel);
		if (personnelSave.getTypesConges()!= null) {
			for( TypeConge type: personnelSave.getTypesConges()) {
				ResteConge resteConge = new ResteConge();
				TypeConge t = typeCongeRepository.findById(type.getId());
				resteConge.setPersonnel(personnelSave);
				resteConge.setType(t);
				resteConge.setDroits(t.getDroits());
				resteConge.setReste(t.getDroits());
				
				resteCongeRepository.save(resteConge);
			}
		}
		
		
		return personnelSave;
	}
	
	@GetMapping("/typesConge/personnels/{id}")
    public Set<TypeConge> getTypesByIdpersonnel(@PathVariable(value = "id") Long personnelId)
        throws ResourceNotFoundException {
        Personnel personnel = personnelRepository.findById(personnelId)
        		
          .orElseThrow(() -> new ResourceNotFoundException("personnel not found for this id :: " + personnelId));
        Set<TypeConge> typesConges= personnel.getTypesConges();
        return typesConges;
    }
	
	@DeleteMapping("/personnels/delete/{id}")
    public void deletePersonnel(@PathVariable(value = "id") Long personnelId) {
         
        personnelRepository.deleteById(personnelId);;
       
	}
   
	@PutMapping("/personnels/edit/{id}")
	public Personnel updatePersonnel(@RequestBody Personnel personnel, @PathVariable long id) {

		Personnel personnelUpdate = personnelRepository.findById(id);

		personnelUpdate.setCin(personnel.getCin());
		personnelUpdate.setDateEmbauche(personnel.getDateEmbauche());
		personnelUpdate.setEchelle(personnel.getEchelle());
		personnelUpdate.setEchlon(personnel.getEchlon());
		personnelUpdate.setEmail(personnel.getEmail());
		personnelUpdate.setGrade(personnel.getGrade());
		personnelUpdate.setIdDivision(personnel.getIdDivision());
		personnelUpdate.setIdService(personnel.getIdService());		
		personnelUpdate.setNom(personnel.getNom());
		personnelUpdate.setPrenom(personnel.getPrenom());
		personnelUpdate.setNiveauAcademique(personnel.getNiveauAcademique());
		personnelUpdate.setTypePersonnel(personnel.getTypePersonnel());
		personnelUpdate.setTelephonefix(personnel.getTelephonefix());
		personnelUpdate.setTelephoneGsm(personnel.getTelephoneGsm());
		personnelUpdate.setSex(personnel.getSex());
		personnelUpdate.setSituationFamiliale(personnel.getSituationFamiliale());
		personnelUpdate.setNbEnfantsM(personnel.getNbEnfantsM());
		personnelUpdate.setNbEnfantsF(personnel.getNbEnfantsF());
		personnelUpdate.setTypesConges(personnel.getTypesConges());
		
		
		personnelRepository.save(personnelUpdate);

		return personnelUpdate;
	}
	@GetMapping("/personnels/checkMatricule/{matricule}")
    public boolean checkMatricule(@PathVariable(value = "matricule") String matricule)
         {
        
          
        return personnelRepository.findByMatricule(matricule) != null;
    }  
	@GetMapping("/personnels/division/{idDivision}")
    public List<PersonnelResponse> getPersonnelsByDividion(@PathVariable(value = "idDivision") long idDivision)
         {
        
          
        return personnelRepository.findByIdDivisionOrderByIdDesc(idDivision);
    }  
	@GetMapping("/personnels/service/{idService}")
    public List<PersonnelResponse> getPersonnelsByService(@PathVariable(value = "idService") long idService)
         {
        
          
        return personnelRepository.findByIdService(idService);
    }
	@GetMapping("/personnels/findByMatricule/{matricule}")
    public Personnel getPersonnelByMatricule(@PathVariable(value = "matricule") String matricule)
         {
        
          
        return personnelRepository.findByMatricule(matricule);
    }  
	
	@GetMapping("/personnels/filter/{filter}")
    public List<Personnel> getByFilter(@PathVariable(value = "filter") String filter) {
		
        return (personnelRepository.findByNomContaining(filter));
    }
	
	@GetMapping("/personnels/find/{id}")
    public PersonnelResponse getPersonnelById(@PathVariable(value = "id") Long id) {
       return personnelRepository.findPersonnelById(id);
    }
	
	@GetMapping("/personnels/myProfile/{id}")
    public ResponseEntity<Personnel> getProfileById(@PathVariable(value = "id") Long personnelId)
        throws ResourceNotFoundException {
        Personnel personnel = personnelRepository.findById(personnelId)
          .orElseThrow(() -> new ResourceNotFoundException("personnel not found for this id :: " + personnelId));
        return ResponseEntity.ok().body(personnel);
    }
}
