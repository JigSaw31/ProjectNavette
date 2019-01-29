package com.formation.projetNavette.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.projetNavette.persistence.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
