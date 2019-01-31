package com.formation.projetNavette.controller;

import java.sql.Date;

import java.sql.Time;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.projetNavette.dto.ReservationLight;
import com.formation.projetNavette.dto.ReservationValidee;
import com.formation.projetNavette.service.IReservationInterface;

class ReservationItemBody {
	public ReservationValidee reservationValidee;
	public Boolean moyenDePaiement;
}

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
	
	@PostMapping(value="/TrajetParJour/{date}/{horaire}/validerReservation")
	@ResponseBody
	public ReservationValidee save(@PathVariable Date date, @PathVariable Time horaire, @RequestBody ReservationItemBody body ) {
			System.out.println("Got it !");
			return reservationInterface.save(date,horaire,body.reservationValidee, body.moyenDePaiement);
	
//				System.out.println("Places : " + body.reservationValidee+" "+ body.moyenDePaiement);
	//return new ReservationValidee();
	}

}
