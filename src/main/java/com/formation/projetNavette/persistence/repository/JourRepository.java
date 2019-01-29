package com.formation.projetNavette.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.projetNavette.persistence.entity.Jour;

public interface JourRepository extends JpaRepository<Jour, Long> {

}
