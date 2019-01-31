package com.formation.projetNavette.dto;

public class ReservationFacture {
	
	private ClientItem client;
	private TrajetParJour trajetConcerne;
	private Double prixTotalHt;
	private Double prixTva;
	private Double prixTotalTtc;
	private int nbPlacesReservees;
	
	
	public ClientItem getClient() {
		return client;
	}
	public void setClient(ClientItem client) {
		this.client = client;
	}
	public TrajetParJour getTrajetConcerne() {
		return trajetConcerne;
	}
	public void setTrajetConcerne(TrajetParJour trajetConcerne) {
		this.trajetConcerne = trajetConcerne;
	}
	public Double getPrixTotalHt() {
		return prixTotalHt;
	}
	public void setPrixTotalHt(Double prixTotalHt) {
		this.prixTotalHt = prixTotalHt;
	}
	public Double getPrixTva() {
		return prixTva;
	}
	public void setPrixTva(Double prixTva) {
		this.prixTva = prixTva;
	}
	public Double getPrixTotalTtc() {
		return prixTotalTtc;
	}
	public void setPrixTotalTtc(Double prixTotalTtc) {
		this.prixTotalTtc = prixTotalTtc;
	}
	public int getNbPlacesReservees() {
		return nbPlacesReservees;
	}
	public void setNbPlacesReservees(int nbPlacesReservees) {
		this.nbPlacesReservees = nbPlacesReservees;
	}
	
}
