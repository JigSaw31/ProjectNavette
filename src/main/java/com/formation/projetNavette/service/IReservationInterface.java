package com.formation.projetNavette.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;


import com.formation.projetNavette.dto.ReservationFacture;
import com.formation.projetNavette.dto.ReservationLight;
import com.formation.projetNavette.dto.ReservationValidee;

public interface IReservationInterface {

	ArrayList<ReservationLight> findByIdClient(Long id);

	ReservationValidee save(Date date, Time horaire, ReservationValidee reservationValidee, Boolean moyenDePaiement);
	
	ArrayList<ReservationFacture> editerFacture(Date date, Time horaire, String mail, String telephone);
}
