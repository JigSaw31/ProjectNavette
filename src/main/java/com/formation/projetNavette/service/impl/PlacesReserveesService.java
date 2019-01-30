package com.formation.projetNavette.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.projetNavette.dto.PlacesReservees;
import com.formation.projetNavette.persistence.entity.Reservation;
import com.formation.projetNavette.persistence.repository.ReservationRepository;
import com.formation.projetNavette.service.IPlacesReserveesService;

@Service
@Transactional
public class PlacesReserveesService implements IPlacesReserveesService {
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Override
	public  PlacesReservees findOne(long id) {
		PlacesReservees item = new PlacesReservees();		
        Optional<Reservation> opt = reservationRepo.findById(id);
        
			item.setNbPlacesReservees(opt.get().getNbPlacesReservees());
			return item;	
	}

}
