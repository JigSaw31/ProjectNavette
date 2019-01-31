package com.formation.projetNavette.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.formation.projetNavette.persistence.entity.Trajet;

public interface TrajetRepository extends JpaRepository<Trajet, Long> {
	
	@Query (value = "SELECT * FROM trajet WHERE id=?1" , nativeQuery = true)
	public Trajet findOne(Long id);

}
