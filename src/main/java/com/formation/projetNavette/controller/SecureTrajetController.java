package com.formation.projetNavette.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.projetNavette.persistence.entity.Trajet;
import com.formation.projetNavette.persistence.repository.TrajetRepository;

@RestController
@RequestMapping(value="api/private/trajet")
public class SecureTrajetController {

	
	@Autowired 
	private TrajetRepository trajetRepository;
	
	@PostMapping
	@ResponseBody
	public Trajet save(@RequestBody Trajet trajet) {
		return trajetRepository.save(trajet);
	}
	
	
}
