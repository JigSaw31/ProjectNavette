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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
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
		@Cascade({CascadeType.PERSIST})
		@JoinColumn (name = "id_navette",referencedColumnName="id")
		private Navette navette;
		
		@ManyToOne
		@Cascade({CascadeType.PERSIST})
		@JoinColumn (name = "id_horaire", referencedColumnName="id")
		private Horaire horaire;
		
		@ManyToOne
		@Cascade({CascadeType.PERSIST})
		@JoinColumn (name = "id_jour",referencedColumnName="id")
		private Jour jour;
		
		@OneToMany
		@JoinColumn(name="id_trajet", referencedColumnName="id")
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

		public List<Reservation> getReservations() {
			return reservations;
		}

		public void setReservations(List<Reservation> reservations) {
			this.reservations = reservations;
		}
		
		
		
}
