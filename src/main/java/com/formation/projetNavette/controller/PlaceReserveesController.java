package com.formation.projetNavette.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.projetNavette.dto.PlacesReservees;
import com.formation.projetNavette.service.IPlacesReserveesService;

@RestController
@RequestMapping(value="/api/public/{date}/{horaire}")

public class PlaceReserveesController {
	
	@Autowired
	private IPlacesReserveesService placesReserveesService;
	
	public PlacesReservees findOne(@PathVariable long id) {
		return placesReserveesService.findOne(id);
	}	


}
