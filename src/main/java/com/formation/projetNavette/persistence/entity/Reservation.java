package com.formation.projetNavette.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Reservation")
public class Reservation {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", unique = true, nullable = false)
	private Long id;

	@Column (name = "nbPlacesReservees")
	private int nbPlacesReservees;
	
	@Column (name = "prixTotalHt")
	private Double prixTotalHt;
	
	@Column (name = "prixTotalTtc")
	private Double prixTotalTtc;
	
	@ManyToOne
	@JoinColumn(name="id_client", referencedColumnName="id")
	private Client client;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
