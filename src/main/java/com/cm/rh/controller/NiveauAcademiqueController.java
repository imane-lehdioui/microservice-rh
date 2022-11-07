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

import com.cm.rh.entity.NiveauAcademique;
import com.cm.rh.repository.NiveauAcademiqueRepository;

import com.cm.rh.exception.ResourceNotFoundException;


@RestController

public class NiveauAcademiqueController {
	
	@Autowired
	private NiveauAcademiqueRepository niveauAcademiqueRepository;
	
	
	 @GetMapping("/niveauAcademiques/index")
	    public List<NiveauAcademique> getAllNiveauAcademiques() {
	        return niveauAcademiqueRepository.findAll();
	    }

	    @GetMapping("/niveauAcademiques/show/{id}")
	    public ResponseEntity<NiveauAcademique> getNiveauAcademiqueById(@PathVariable(value = "id") Long niveauAcademiqueId)
	        throws ResourceNotFoundException {
	        NiveauAcademique niveauAcademique = niveauAcademiqueRepository.findById(niveauAcademiqueId)
	          .orElseThrow(() -> new ResourceNotFoundException("niveauAcademique not found for this id :: " + niveauAcademiqueId));
	        return ResponseEntity.ok().body(niveauAcademique);
	    }
	    
	    @PostMapping("/niveauAcademiques/new")
	    public NiveauAcademique createNiveauAcademique(@Valid @RequestBody NiveauAcademique niveauAcademique) {
	        return niveauAcademiqueRepository.save(niveauAcademique);
	    }

	    @PutMapping("/niveauAcademiques/edit/{id}")
	    public ResponseEntity<NiveauAcademique> updateNiveauAcademique(@PathVariable(value = "id") Long niveauAcademiqueId,
	         @Valid @RequestBody NiveauAcademique niveauAcademiqueDetails) throws ResourceNotFoundException {
	        NiveauAcademique niveauAcademique = niveauAcademiqueRepository.findById(niveauAcademiqueId)
	        .orElseThrow(() -> new ResourceNotFoundException("niveauAcademique not found for this id :: " + niveauAcademiqueId));

	        niveauAcademique.setLibelle(niveauAcademiqueDetails.getLibelle());	        
	        final NiveauAcademique updatedNiveauAcademique = niveauAcademiqueRepository.save(niveauAcademique);
	        return ResponseEntity.ok(updatedNiveauAcademique);
	    }

	    @DeleteMapping("/niveauAcademiques/delete/{id}")
	    public Map<String, Boolean> deleteNiveauAcademique(@PathVariable(value = "id") Long niveauAcademiqueId)
	         throws ResourceNotFoundException {
	        NiveauAcademique niveauAcademique = niveauAcademiqueRepository.findById(niveauAcademiqueId)
	       .orElseThrow(() -> new ResourceNotFoundException("niveauAcademique not found for this id :: " + niveauAcademiqueId));

	        niveauAcademiqueRepository.delete(niveauAcademique);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}
