package com.formation.projetNavette.controller;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.projetNavette.dto.ReservationLight;
import com.formation.projetNavette.service.IReservationInterface;

@RestController
@RequestMapping(value="api/public/reservation")
public class ReservationController {
	
	@Autowired
	private IReservationInterface reservationInterface;
	
	@GetMapping(value="/reservationClient/{id}")
	@ResponseBody
	public ArrayList<ReservationLight> findByIdClient(@PathVariable Long id){
		return reservationInterface.findByIdClient(id);
	}

}
