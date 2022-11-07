package com.cm.rh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cm.rh.entity.SituationFamiliale;
import com.cm.rh.repository.SituationFamilialeRepository;

@RestController
public class SituationFamilialeController {

	@Autowired
	private SituationFamilialeRepository situationFamilialeRepository;
	
	@GetMapping("/situationFamiliales/index")
    public List<SituationFamiliale> getAllSituationFamiliales() {
        return situationFamilialeRepository.findAll();
    }
}
