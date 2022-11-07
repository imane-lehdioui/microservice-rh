package com.cm.rh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.cm.rh.entity.TypePersonnel;
import com.cm.rh.repository.TypePersonnelRepository;

import com.cm.rh.exception.ResourceNotFoundException;


@RestController
public class TypePersonnelController {
	
	@Autowired
	private TypePersonnelRepository typePersonnelRepository;
	
	
	 @GetMapping("/typePersonnels/index")
	    public List<TypePersonnel> getAllTypePersonnels() {
	        return typePersonnelRepository.findAll();
	    }

	    @GetMapping("/typePersonnels/show/{id}")
	    public ResponseEntity<TypePersonnel> getTypePersonnelById(@PathVariable(value = "id") Long typePersonnelId)
	        throws ResourceNotFoundException {
	        TypePersonnel typePersonnel = typePersonnelRepository.findById(typePersonnelId)
	          .orElseThrow(() -> new ResourceNotFoundException("typePersonnel not found for this id :: " + typePersonnelId));
	        return ResponseEntity.ok().body(typePersonnel);
	    }
	    
	    @PostMapping("/typePersonnels/new")
	    public TypePersonnel createTypePersonnel(@Valid @RequestBody TypePersonnel typePersonnel) {
	        return typePersonnelRepository.save(typePersonnel);
	    }

	    @PutMapping("/typePersonnels/edit/{id}")
	    public ResponseEntity<TypePersonnel> updateTypePersonnel(@PathVariable(value = "id") Long typePersonnelId,
	         @Valid @RequestBody TypePersonnel typePersonnelDetails) throws ResourceNotFoundException {
	        TypePersonnel typePersonnel = typePersonnelRepository.findById(typePersonnelId)
	        .orElseThrow(() -> new ResourceNotFoundException("typePersonnel not found for this id :: " + typePersonnelId));

	        typePersonnel.setLibelle(typePersonnelDetails.getLibelle());	        
	        final TypePersonnel updatedTypePersonnel = typePersonnelRepository.save(typePersonnel);
	        return ResponseEntity.ok(updatedTypePersonnel);
	    }

	    @DeleteMapping("/typePersonnels/delete/{id}")
	    public Map<String, Boolean> deleteTypePersonnel(@PathVariable(value = "id") Long typePersonnelId)
	         throws ResourceNotFoundException {
	        TypePersonnel typePersonnel = typePersonnelRepository.findById(typePersonnelId)
	       .orElseThrow(() -> new ResourceNotFoundException("typePersonnel not found for this id :: " + typePersonnelId));

	        typePersonnelRepository.delete(typePersonnel);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }


}
