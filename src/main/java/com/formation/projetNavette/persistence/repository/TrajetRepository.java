package com.formation.projetNavette.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.projetNavette.persistence.entity.Trajet;

public interface TrajetRepository extends JpaRepository<Trajet, Long> {

}
