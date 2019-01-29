package com.formation.projetNavette.service;

import java.sql.Date;
import java.util.List;

import com.formation.projetNavette.dto.TrajetParJour;
import com.formation.projetNavette.persistence.entity.Trajet;

public interface ITrajetInterface {
	
	List<Trajet> findAll(Date date);

}
