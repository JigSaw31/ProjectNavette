package com.formation.projetNavette.service.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.projetNavette.dto.ClientItem;
import com.formation.projetNavette.dto.ReservationFacture;
import com.formation.projetNavette.dto.ReservationItem;
import com.formation.projetNavette.dto.ReservationLight;
import com.formation.projetNavette.dto.ReservationValidee;
import com.formation.projetNavette.dto.TrajetParJour;
import com.formation.projetNavette.exception.NotIdentifiedException;
import com.formation.projetNavette.persistence.entity.Client;
import com.formation.projetNavette.persistence.entity.Reservation;
import com.formation.projetNavette.persistence.entity.Trajet;
import com.formation.projetNavette.persistence.repository.ReservationRepository;
import com.formation.projetNavette.service.IReservationInterface;
import com.formation.projetNavette.service.impl.TrajetService;
import com.formation.projetNavette.service.impl.ClientService;

@Service
@Transactional
public class ReservationService implements IReservationInterface {

	@Autowired
	private ReservationRepository reservationRepository;
	
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private TrajetService trajetService;
	
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
	@Override
	public ReservationValidee save(Date date, Time horaire, ReservationValidee reservationValidee,Boolean moyenDePaiement) {
		
		ReservationItem reservationItem= trajetService.ouvrirReservation(date, horaire, reservationValidee.getNbPlacesReservees());
		Client clientEnregistre=clientService.findByMailAndTelephone(reservationValidee.getMail(), reservationValidee.getTelephone());
		Trajet trajet= trajetService.findOne(reservationItem.getTrajetConcerne().getId());
		Reservation reservation = new Reservation();
		Client client= new Client();
				
		if (moyenDePaiement) {
		 
		reservation.setNbPlacesReservees(reservationItem.getNbPlacesReservees());
		reservation.setPrixTotalHt(reservationItem.getPrixTotalHt());
		reservation.setPrixTotalTtc(reservationItem.getPrixTotalTtc());
		
		if (clientEnregistre!= null) {
		reservation.setClient(clientEnregistre);
		}
		else {
			client.setNom(reservationValidee.getNom());
			client.setPrenom(reservationValidee.getPrenom());
			client.setMail(reservationValidee.getMail());
			client.setTelephone(reservationValidee.getTelephone());
			clientService.save(client);
			reservation.setClient(client);
		}
		reservationRepository.save(reservation);
		
		trajet.getReservations().add(reservation);
		trajet.setNbPlaceDisponible(trajet.getNbPlaceDisponible()-reservation.getNbPlacesReservees());
		
		trajetService.save(trajet);
		trajetService.validationReservation(reservationValidee.getMail(), true);
		return reservationValidee;	
		} else { 
			throw new NotIdentifiedException("Moyen de paiement refusé !");
		   }
	}

	@Override
	public ArrayList<ReservationFacture> editerFacture(Date date, Time horaire, String mail, String telephone) {
		Client client=clientService.findByMailAndTelephone(mail,telephone);
		ArrayList<TrajetParJour> trajets=trajetService.findByHoraire(horaire, date);
		ArrayList<ReservationFacture> factures = new ArrayList<ReservationFacture>();
		for (TrajetParJour trajetParJour:trajets) {
		Trajet trajet=trajetService.findOne(trajetParJour.getId());
		
		ReservationFacture facture= new ReservationFacture();
		ClientItem clientItem= new ClientItem(client);
		

		
		for(Reservation reservation: trajet.getReservations()) {
			if ((reservation.getClient())==(client)) {
				
				facture.setTrajetConcerne(trajetParJour);
				facture.setPrixTotalHt(reservation.getPrixTotalHt());
				facture.setPrixTotalTtc(reservation.getPrixTotalTtc());
				facture.setPrixTva(facture.getPrixTotalTtc()-facture.getPrixTotalHt());
				facture.setNbPlacesReservees(reservation.getNbPlacesReservees());
				
				facture.setClient(clientItem);
				factures.add(facture);
			}}
			
		
		}		
		return factures;
			}
	}
	

