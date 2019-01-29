package com.formation.projetNavette.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Trajet")
public class Trajet {
	
	
		
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column (name = "id", unique = true, nullable = false)
		private Long id;

		@Column (name = "nbPlaceDisponible", length=100, nullable=false)
		private Integer nbPlaceDisponible;
		
		@ManyToOne
		@JoinColumn (name = "idNavette",referencedColumnName="id")
		private Navette navette;
		
		@ManyToOne
		@JoinColumn (name = "idHoraire", referencedColumnName="id")
		private Horaire horaire;
		
		@ManyToOne
		@JoinColumn (name = "idJour",referencedColumnName="id")
		private Jour jour;
		
		@OneToMany
		@JoinColumn(name="idReservation", referencedColumnName="id")
		private List<Reservation> reservations;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Integer getNbPlaceDisponible() {
			return nbPlaceDisponible;
		}

		public void setNbPlaceDisponible(Integer nbPlaceDisponible) {
			this.nbPlaceDisponible = nbPlaceDisponible;
		}

		public Navette getNavette() {
			return navette;
		}

		public void setNavette(Navette navette) {
			this.navette = navette;
		}

		public Horaire getHoraire() {
			return horaire;
		}

		public void setHoraire(Horaire horaire) {
			this.horaire = horaire;
		}

		public Jour getJour() {
			return jour;
		}

		public void setJour(Jour jour) {
			this.jour = jour;
		}
		
		
}
