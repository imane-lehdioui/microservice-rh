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

import com.cm.rh.entity.DemandeConge;
import com.cm.rh.exception.ResourceNotFoundException;
import com.cm.rh.repository.DemandeCongeRepository;


@RestController
public class DemandeCongeController {
	
	@Autowired
	private DemandeCongeRepository demandeCongeRepository;
	
	@GetMapping("/demandeConges/index")
    public List<DemandeConge> getAllDemandes() {
        return demandeCongeRepository.findAllByOrderByIdDesc();
    }
	
	@GetMapping("/demandeConges/show/{id}")
    public ResponseEntity<DemandeConge> getDemandeById(@PathVariable(value = "id") Long resteCongeId)
        throws ResourceNotFoundException {
        DemandeConge demandeConge = demandeCongeRepository.findById(resteCongeId)
          .orElseThrow(() -> new ResourceNotFoundException("demandeConge not found for this id :: " +resteCongeId));
        return ResponseEntity.ok().body(demandeConge);
    }
	
	@PostMapping("/demandeConges/new")
	public DemandeConge createDemande(@Valid @RequestBody DemandeConge demandeConge) {
		
		return demandeCongeRepository.save(demandeConge);
	}
	
	@DeleteMapping("/demandeConges/delete/{id}")
    public void deleteDemande(@PathVariable(value = "id") Long resteCongeId) {
         
        demandeCongeRepository.deleteById(resteCongeId);;
       
	}
   
	@PutMapping("/demandeConges/edit/{id}")
	public ResponseEntity<Object> updateDemande(@RequestBody DemandeConge demandeConge, @PathVariable long id) {

		Optional<DemandeConge> resteCongeUpdate = demandeCongeRepository.findById(id);

		if (!resteCongeUpdate.isPresent())
			return ResponseEntity.notFound().build();

		demandeConge.setId(id);
		
		demandeCongeRepository.save(demandeConge);

		return ResponseEntity.noContent().build();
	}



}
