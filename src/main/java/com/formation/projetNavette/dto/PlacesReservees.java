package com.formation.projetNavette.dto;


public class PlacesReservees {
	
	private int nbPlacesReservees;
	
	public PlacesReservees() {
		
	}
	
//	public PlacesReservees(Reservation r) {
//		this.setNbPlacesReservees(r.getNbPlacesReservees());
//	}

	public int getNbPlacesReservees() {
		return nbPlacesReservees;
	}
	
	public void setNbPlacesReservees(int nbPlacesReservees) {
		this.nbPlacesReservees = nbPlacesReservees;
	}
	
	
}
