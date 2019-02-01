package com.formation.projetNavette.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

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

import com.formation.projetNavette.dto.TrajetParJour;
import com.formation.projetNavette.persistence.entity.Trajet;
import com.formation.projetNavette.persistence.repository.TrajetRepository;
import com.formation.projetNavette.service.impl.MailService;
import com.formation.projetNavette.service.impl.TrajetService;

@RestController
@RequestMapping(value="api/private/trajet")
public class SecureTrajetController {

	
	@Autowired 
	private TrajetRepository trajetRepository;
	
	@Autowired 
	private TrajetService trajetService;
	
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
		MailService.envoiMail("");
	}
	
	
	@GetMapping(value="/trajet/{date}/{horaire}")
	@ResponseBody
	public ArrayList<TrajetParJour> tauxOccupation(@PathVariable Date date, @PathVariable Time horaire) {
		return trajetService.findByHoraire(horaire, date);
	}

}
