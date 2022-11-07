package com.cm.rh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cm.rh.entity.Sex;

import com.cm.rh.repository.SexRepository;

@RestController
public class SexController {

	@Autowired
	private SexRepository sexRepository;
	
	@GetMapping("/sex/index")
    public List<Sex> getAllSex() {
        return sexRepository.findAll();
    }
}
