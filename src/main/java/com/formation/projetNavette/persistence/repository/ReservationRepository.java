package com.formation.projetNavette.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.formation.projetNavette.persistence.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}

