package com.formation.projetNavette.dto;

public class ReservationLight {
	
	private Long numéro;
	
	private int nbPlacesReserveesDTO;
	
	private Double prixTotalHtDTO;
	
	private Double prixTotalTtcDTO;

	public Long getNuméro() {
		return numéro;
	}

	public void setNuméro(Long numéro) {
		this.numéro = numéro;
	}

	public int getNbPlacesReserveesDTO() {
		return nbPlacesReserveesDTO;
	}

	public void setNbPlacesReserveesDTO(int nbPlacesReserveesDTO) {
		this.nbPlacesReserveesDTO = nbPlacesReserveesDTO;
	}

	public Double getPrixTotalHtDTO() {
		return prixTotalHtDTO;
	}

	public void setPrixTotalHtDTO(Double prixTotalHtDTO) {
		this.prixTotalHtDTO = prixTotalHtDTO;
	}

	public Double getPrixTotalTtcDTO() {
		return prixTotalTtcDTO;
	}

	public void setPrixTotalTtcDTO(Double prixTotalTtcDTO) {
		this.prixTotalTtcDTO = prixTotalTtcDTO;
	}

	
	
}
