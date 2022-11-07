package com.cm.rh.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cm.rh.entity.StatutDemandeConge;
import com.cm.rh.exception.ResourceNotFoundException;
import com.cm.rh.repository.StatutDemandeCongeRepository;


@RestController
public class StatutDemandeCongeController {
	
	@Autowired
	private StatutDemandeCongeRepository statutDemandeCongeRepository;
	
	@GetMapping("/statutsDemandes")
    public List<StatutDemandeConge> getAllStatuts() {
        return statutDemandeCongeRepository.findAll();
    }
	
	@GetMapping("/statutsDemandes/{id}")
    public ResponseEntity<StatutDemandeConge> getStatutById(@PathVariable(value = "id") Long resteCongeId)
        throws ResourceNotFoundException {
        StatutDemandeConge statutDemandeConge = statutDemandeCongeRepository.findById(resteCongeId)
          .orElseThrow(() -> new ResourceNotFoundException("statutDemandeConge not found for this id :: " +resteCongeId));
        return ResponseEntity.ok().body(statutDemandeConge);
    }
	
	@PostMapping("/statutsDemandes")
	public StatutDemandeConge createStatut(@Valid @RequestBody StatutDemandeConge statutDemandeConge) {
		
		return statutDemandeCongeRepository.save(statutDemandeConge);
	}
	
	@DeleteMapping("/statutsDemandes/{id}")
    public void deleteStatut(@PathVariable(value = "id") Long statutId) {
         
        statutDemandeCongeRepository.deleteById(statutId);;
       
	}
   
	@PutMapping("/statutsDemandes/{id}")
	public ResponseEntity<Object> updateStatut(@RequestBody StatutDemandeConge statutDemandeConge, @PathVariable long id) {

		Optional<StatutDemandeConge> resteCongeUpdate = statutDemandeCongeRepository.findById(id);

		if (!resteCongeUpdate.isPresent())
			return ResponseEntity.notFound().build();

		statutDemandeConge.setId(id);
		
		statutDemandeCongeRepository.save(statutDemandeConge);

		return ResponseEntity.noContent().build();
	}


}
