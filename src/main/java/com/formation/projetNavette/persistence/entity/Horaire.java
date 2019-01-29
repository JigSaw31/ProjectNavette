package com.formation.projetNavette.persistence.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Horaire")
public class Horaire {
		
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column (name = "id", unique = true, nullable = false)
		private Long id;

		@Column (name = "horaire")
		private Time horaire;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Time getHoraire() {
			return horaire;
		}

		public void setHoraire(Time horaire) {
			this.horaire = horaire;
		}

		
		
}
