package com.formation.projetNavette.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.projetNavette.persistence.entity.Navette;

public interface NavetteRepository extends JpaRepository<Navette, Long> {

}
