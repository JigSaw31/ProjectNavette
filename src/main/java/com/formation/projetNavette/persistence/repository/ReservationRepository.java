package com.formation.projetNavette.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.formation.projetNavette.persistence.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	@Query(value="SELECT * FROM Reservation where id_client=?1", nativeQuery=true)
	List<Reservation> findReservationIdClient(Long id);
	

}

