package com.formation.projetNavette.dto;


public class ReservationItem {
	
	private Double prixTotalHt;
	private Double prixTotalTtc;
	private int nbPlacesReservees;
	private TrajetParJour trajetConcerne;
	
	

	public ReservationItem() {
		
	}
	
	

	public TrajetParJour getTrajetConcerne() {
		return trajetConcerne;
	}



	public void setTrajetConcerne(TrajetParJour trajetConcerne) {
		this.trajetConcerne = trajetConcerne;
	}



	public int getNbPlacesReservees() {
		return nbPlacesReservees;
	}
	
	public void setNbPlacesReservees(int nbPlacesReservees) {
		this.nbPlacesReservees = nbPlacesReservees;
	}
	
	public Double getPrixTotalHt() {
		return prixTotalHt;
	}

	public void setPrixTotalHt(Double prixTotalHt) {
		this.prixTotalHt = prixTotalHt;
	}

	public Double getPrixTotalTtc() {
		return prixTotalTtc;
	}

	public void setPrixTotalTtc(Double prixTotalTtc) {
		this.prixTotalTtc = prixTotalTtc;
	}
	
	
}
