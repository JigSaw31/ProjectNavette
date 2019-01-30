package com.formation.projetNavette.service.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.imageio.ImageTranscoder;
import javax.security.auth.x500.X500Principal;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.formation.projetNavette.dto.TrajetParJour;
import com.formation.projetNavette.persistence.entity.Horaire;
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
			
			trajetParJours.add(trajetParJour);
		}
		
		return trajetParJours;
	}

	

	@Override
	public List<TrajetParJour> findByHoraire(Time horaire, Date date) {
		
		ArrayList<TrajetParJour> trajetParHoraires = findAll(date);
		  
		
		trajetParHoraires = (ArrayList<TrajetParJour>) trajetParHoraires.stream().filter(x -> x.getTime().equals(horaire)).collect(Collectors.toList());
		
		return trajetParHoraires;
		
	
	}
}

