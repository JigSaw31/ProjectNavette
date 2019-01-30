package com.formation.projetNavette.service;

import java.util.ArrayList;

import com.formation.projetNavette.dto.ReservationLight;

public interface IReservationInterface {

	ArrayList<ReservationLight> findByIdClient(Long id);
	
}
