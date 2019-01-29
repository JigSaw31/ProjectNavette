package com.formation.projetNavette.dto;

import java.sql.Date;
import java.sql.Time;

public class TrajetParJour {
	
	private Date date;
	
	private Time time;
	
	private int placesDisponibles;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public int getPlacesDisponibles() {
		return placesDisponibles;
	}

	public void setPlacesDisponibles(int placesDisponibles) {
		this.placesDisponibles = placesDisponibles;
	}
	
	

}
