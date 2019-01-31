package com.formation.projetNavette.dto;

import com.formation.projetNavette.persistence.entity.Client;

public class ClientItem {
	
	private Long id;
	private String nom;
	private String prenom;
	private String telephone;
	private String mail;
	
	public ClientItem(Client client) {
		this.setNom(client.getNom());
		this.setPrenom(client.getPrenom());
		this.setMail(client.getMail());
		this.setId(client.getId());
		this.setTelephone(client.getTelephone());
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

	public void setPrenom(String prneom) {
		this.prenom = prneom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
