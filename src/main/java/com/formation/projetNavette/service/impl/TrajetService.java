package com.formation.projetNavette.service.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;





import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.formation.projetNavette.dto.ReservationItem;

import com.formation.projetNavette.dto.TrajetParJour;

import com.formation.projetNavette.exception.NotIdentifiedException;

import com.formation.projetNavette.persistence.entity.Reservation;

import com.formation.projetNavette.persistence.entity.Trajet;

import com.formation.projetNavette.persistence.repository.TrajetRepository;
import com.formation.projetNavette.service.ITrajetInterface;



@Service
@Transactional
public class TrajetService implements ITrajetInterface {
	
	@Autowired
	private TrajetRepository trajetRepository;
	

	@Override
	public ArrayList<TrajetParJour> findAll(Date date) {
		
		List<Trajet> trajets = trajetRepository.findAll();
		ArrayList<TrajetParJour> trajetParJours = new ArrayList<TrajetParJour>();
		
		trajets = trajets.stream().filter(x -> x.getJour().getJour().equals(date)).collect(Collectors.toList());
		
		for (Trajet trajet : trajets) {
			TrajetParJour trajetParJour = new TrajetParJour();
			trajetParJour.setDate(trajet.getJour().getJour());
			trajetParJour.setTime(trajet.getHoraire().getHoraire());
			trajetParJour.setPlacesDisponibles(trajet.getNbPlaceDisponible());
			trajetParJour.setId(trajet.getId());
			
			trajetParJours.add(trajetParJour);
		}
		if (trajetParJours.size()!= 0) {
		return trajetParJours;
		
		} else {
			throw new NotIdentifiedException("Il n'y a pas de trajets pour ce jour !");
		}
	}

	

	@Override
	public ArrayList<TrajetParJour> findByHoraire(Time horaire, Date date) {
		
		ArrayList<TrajetParJour> trajetParHoraires = findAll(date);	  
		
		trajetParHoraires = (ArrayList<TrajetParJour>) trajetParHoraires.stream().filter(x -> x.getTime().equals(horaire)).collect(Collectors.toList());

		if (trajetParHoraires.size()!= 0) {
			return trajetParHoraires;
			
			} else {
				throw new NotIdentifiedException("Il n'y a pas de trajets pour cette horaire !");
			}
		
	}



	@Override
	public ReservationItem ouvrirReservation(Date date,Time horaire, int nbre) {
		
		ReservationItem reservation = new ReservationItem();
		
       ArrayList<TrajetParJour> trajets = findByHoraire(horaire,date);
		
       		for( TrajetParJour trajet: trajets) {
			TrajetParJour trajetParJour = new TrajetParJour();
			trajetParJour.setPlacesDisponibles(trajet.getPlacesDisponibles());
			trajetParJour.setDate(trajet.getDate());
			trajetParJour.setTime(trajet.getTime());
			trajetParJour.setId(trajet.getId());
			if (nbre <= trajetParJour.getPlacesDisponibles()) {
		 reservation.setPrixTotalHt(8*(double)nbre);
		 reservation.setPrixTotalTtc(8*(double)nbre*1.2);
		 reservation.setNbPlacesReservees(nbre);
		 reservation.setTrajetConcerne(trajetParJour);
		 
		} else {
				throw new NotIdentifiedException("Il n'y a pas assez de places disponibles pour votre réservation !");
			   }
 
       	} 
		return reservation;
    }



	public Trajet findOne(Long id) {
		Trajet trajet=trajetRepository.findOne(id);
		return trajet;
	}



	public Trajet save(Trajet trajet) {
		return trajetRepository.save(trajet);
		
		
		
	}
	
    public String validationReservation(String mail, boolean x) {
		
		if (x == true) {	
				MailService.envoiMail(mail);
				return "Commande validée !";			}

		else {
	return "Abandon !";
		}
		}
    
 public String annulerReservation(String mail, boolean x) {
		
		if (x == true) {	
				MailService.envoiMail(mail);
				return "Commande annulée, mail envoyé à "+ mail+ " .";			}

		else {
	return "Abandon !";
		}
		}
		
	@Override
	public String annulation(Date date, Time horaire) {
			ArrayList<TrajetParJour> trajets= findByHoraire(horaire,date);
			 List<Reservation> reservations= trajetRepository.getOne(trajets.get(0).getId()).getReservations();
			 String reponse=new String();
			
			
			 trajetRepository.deleteById(trajets.get(0).getId());
			 for(Reservation reservation:reservations) {
				 reponse += annulerReservation(reservation.getClient().getMail(), true);
				 
				 
			 }
			
			 
			 return reponse;
    }	




//
//	@Override
//	public ReservationValidee save(Date date, Time horaire, ReservationValidee reservationValidee,
//			Boolean moyenDePaiement) {
//		ReservationItem reservationItem= ouvrirReservation(date, horaire, reservationValidee.getNbPlacesReservees());
//		
//		reservationRepository.save(reservationValidee);
//			
//			
//		
//		return null;
//	}
}

