package com.formation.projetNavette.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.projetNavette.dto.ReservationLight;
import com.formation.projetNavette.persistence.entity.Reservation;
import com.formation.projetNavette.persistence.repository.ReservationRepository;
import com.formation.projetNavette.service.IReservationInterface;

@Service
@Transactional
public class ReservationService implements IReservationInterface {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public ArrayList<ReservationLight> findByIdClient(Long id) {
		List<Reservation> reservations = reservationRepository.findReservationIdClient(id);
		ArrayList<ReservationLight> reservationLights = new ArrayList<ReservationLight>();
		
		for (Reservation reservation : reservations) {
			
			ReservationLight reservationLight = new ReservationLight();
			reservationLight.setNuméro(reservation.getId());
			reservationLight.setNbPlacesReserveesDTO(reservation.getNbPlacesReservees());
			reservationLight.setPrixTotalHtDTO(reservation.getPrixTotalHt());
			reservationLight.setPrixTotalTtcDTO(reservation.getPrixTotalTtc());
			
			reservationLights.add(reservationLight);
		}
		
		return reservationLights;
	}

	
}
