package com.formation.projetNavette.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.projetNavette.dto.ReservationFacture;
import com.formation.projetNavette.service.impl.ReservationService;

class ReservationFactureBody{
	public String mail;
	public String telephone;
	
	
}
@RestController
@RequestMapping(value="api/private/reservation")
public class SecureReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping (value="/{date}/{horaire}")
	@ResponseBody
	private ArrayList<ReservationFacture> editerFacture(@PathVariable Date date, @PathVariable Time horaire,@RequestBody ReservationFactureBody body) {
		return reservationService.editerFacture(date, horaire, body.mail, body.telephone);
	}

}
