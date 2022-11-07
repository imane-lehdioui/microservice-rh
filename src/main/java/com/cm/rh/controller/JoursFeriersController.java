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

import com.cm.rh.entity.JoursFeriers;
import com.cm.rh.exception.ResourceNotFoundException;
import com.cm.rh.repository.JoursFeriersRepository;


@RestController
public class JoursFeriersController {
	
	@Autowired
	private JoursFeriersRepository joursFeriersRepository;
	
	@GetMapping("/joursFeriers/index")
    public List<JoursFeriers> getAllJours() {
        return joursFeriersRepository.findAll();
    }
	
	@GetMapping("/joursFeriers/show/{id}")
    public ResponseEntity<JoursFeriers> getJourById(@PathVariable(value = "id") Long resteCongeId)
        throws ResourceNotFoundException {
        JoursFeriers joursFeriers = joursFeriersRepository.findById(resteCongeId)
          .orElseThrow(() -> new ResourceNotFoundException("joursFeriers not found for this id :: " +resteCongeId));
        return ResponseEntity.ok().body(joursFeriers);
    }
	
	@PostMapping("/joursFeriers/new")
	public JoursFeriers createJour(@Valid @RequestBody JoursFeriers joursFeriers) {
		
		return joursFeriersRepository.save(joursFeriers);
	}
	
	@DeleteMapping("/joursFeriers/delete/{id}")
    public void deleteJour(@PathVariable(value = "id") Long jourId) {
         
        joursFeriersRepository.deleteById(jourId);;
       
	}
   
	@PutMapping("/joursFeriers/edit/{id}")
	public ResponseEntity<Object> updateJour(@RequestBody JoursFeriers joursFeriers, @PathVariable long id) {

		Optional<JoursFeriers> resteCongeUpdate = joursFeriersRepository.findById(id);

		if (!resteCongeUpdate.isPresent())
			return ResponseEntity.notFound().build();

		joursFeriers.setId(id);
		
		joursFeriersRepository.save(joursFeriers);

		return ResponseEntity.noContent().build();
	}


}
