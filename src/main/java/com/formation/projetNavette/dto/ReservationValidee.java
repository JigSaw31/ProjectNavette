package com.formation.projetNavette.dto;




public class ReservationValidee {
	
	
	private int nbPlacesReservees;
	private String nom;
	
	
	private String prenom;
	
	
	private String mail;
	
	
	private String telephone;
	



	public int getNbPlacesReservees() {
		return nbPlacesReservees;
	}



	public void setNbPlacesReservees(int nbPlacesReservees) {
		this.nbPlacesReservees = nbPlacesReservees;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	
}
