package com.cm.rh.controller;

import java.util.List;


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

import com.cm.rh.entity.TypeConge;
import com.cm.rh.exception.ResourceNotFoundException;
import com.cm.rh.repository.TypeCongeRepository;





@RestController
public class TypeCongeController {
	
	@Autowired
	private TypeCongeRepository typeRepository;
	
	@GetMapping("/typeConges/index")
    public List<TypeConge> getAllTypes() {
        return typeRepository.findAll();
    }
	
	@GetMapping("/typeConges/show/{id}")
    public ResponseEntity<TypeConge> getTypeById(@PathVariable(value = "id") Long typeCongeId)
        throws ResourceNotFoundException {
        TypeConge typeConge = typeRepository.findById(typeCongeId)
          .orElseThrow(() -> new ResourceNotFoundException("typeConge not found for this id :: " + typeCongeId));
        return ResponseEntity.ok().body(typeConge);
    }
	
	@PostMapping("/typeConges/new")
	public TypeConge createType(@Valid @RequestBody TypeConge typeConge) {
		
		return typeRepository.save(typeConge);
	}
	
	@DeleteMapping("/typeConges/delete/{id}")
    public void deleteType(@PathVariable(value = "id") Long typeCongeId) {
         
        typeRepository.deleteById(typeCongeId);;
       
	}
   
	@PutMapping("/typeConges/edit/{id}")
	public ResponseEntity<Object> updateType(@RequestBody TypeConge typeConge, @PathVariable long id) {

		TypeConge typeCongeUpdate = typeRepository.findById(id);

		

		typeConge.setId(id);
		
		typeRepository.save(typeConge);

		return ResponseEntity.noContent().build();
	}


}
