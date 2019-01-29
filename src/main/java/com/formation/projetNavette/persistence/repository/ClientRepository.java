package com.formation.projetNavette.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.projetNavette.persistence.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
