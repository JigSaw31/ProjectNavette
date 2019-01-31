package com.formation.projetNavette.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formation.projetNavette.persistence.entity.Trajet;
import com.formation.projetNavette.persistence.repository.TrajetRepository;
import com.formation.projetNavette.service.impl.MailService;

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
	
	@DeleteMapping(value="/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		trajetRepository.deleteById(id);
	}
	
	@PostMapping(value="/mail")
	@ResponseBody
	public void envoiMail() {
		MailService.envoiMail();
	}
	
}
