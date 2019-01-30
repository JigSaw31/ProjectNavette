package com.formation.projetNavette.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.formation.projetNavette.dto.TrajetParJour;

import com.formation.projetNavette.persistence.entity.Trajet;

public interface ITrajetInterface {
	
	ArrayList<TrajetParJour> findAll(Date date);
	

	List<TrajetParJour> findByHoraire(Time horaire, Date date);

}
