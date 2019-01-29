package com.formation.projetNavette.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.projetNavette.dto.TrajetParJour;
import com.formation.projetNavette.persistence.entity.Trajet;
import com.formation.projetNavette.service.ITrajetInterface;
import com.formation.projetNavette.service.impl.TrajetService;

@RestController
@RequestMapping(value="/api/public/navette")
public class TrajetController {

	
	@Autowired
	private ITrajetInterface trajetInterface;
	
	@GetMapping(value="/TrajetParJour/{date}")
	@ResponseBody
	public List<Trajet> findAll(@PathVariable Date date){
		return trajetInterface.findAll(date);
	}
	
		
	
	
}
