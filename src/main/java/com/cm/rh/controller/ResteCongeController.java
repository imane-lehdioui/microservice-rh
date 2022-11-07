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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cm.rh.entity.Personnel;
import com.cm.rh.entity.ResteConge;
import com.cm.rh.entity.TypeConge;
import com.cm.rh.exception.ResourceNotFoundException;
import com.cm.rh.repository.PersonnelRepository;
import com.cm.rh.repository.ResteCongeRepository;
import com.cm.rh.repository.TypeCongeRepository;



@RestController
public class ResteCongeController {
	
	@Autowired
	private ResteCongeRepository resteCongeRepository;
	@Autowired
	private PersonnelRepository personnelRepository;
	@Autowired
	private TypeCongeRepository typeCongeRepository;
	
	@GetMapping("/resteConges/index")
    public List<ResteConge> getAllRestes() {
        return resteCongeRepository.findAll();
    }
	
	@GetMapping("/resteConges/show/{id}")
    public ResponseEntity<ResteConge> getResteById(@PathVariable(value = "id") Long resteCongeId)
        throws ResourceNotFoundException {
        ResteConge resteConge = resteCongeRepository.findById(resteCongeId)
          .orElseThrow(() -> new ResourceNotFoundException("resteConge not found for this id :: " +resteCongeId));
        return ResponseEntity.ok().body(resteConge);
    }
	
	@GetMapping("/resteConge")
	@ResponseBody
    public ResteConge getResteByPersonnelType(@RequestParam List<Long> id) {
		
		Optional<Personnel> personnel = personnelRepository.findById(id.get(0));
		Optional<TypeConge> type = typeCongeRepository.findById(id.get(1));
		ResteConge resteConge = resteCongeRepository.findResteByPersonnelAndType(personnel, type);
		
		return resteConge;
		
        
    }
	
	@PostMapping("/resteConges/new")
	public ResteConge createReste(@Valid @RequestBody ResteConge resteConge) {
		
		return resteCongeRepository.save(resteConge);
	}
	
	@DeleteMapping("/resteConges/delete/{id}")
    public void deleteReste(@PathVariable(value = "id") Long resteCongeId) {
         
        resteCongeRepository.deleteById(resteCongeId);;
       
	}
   
	@PutMapping("/resteConges/edit/{id}")
	public ResponseEntity<Object> updateReste(@RequestBody ResteConge resteConge, @PathVariable long id) {

		Optional<ResteConge> resteCongeUpdate = resteCongeRepository.findById(id);

		if (!resteCongeUpdate.isPresent())
			return ResponseEntity.notFound().build();

		resteConge.setId(id);
		
		resteCongeRepository.save(resteConge);

		return ResponseEntity.noContent().build();
	}


}
