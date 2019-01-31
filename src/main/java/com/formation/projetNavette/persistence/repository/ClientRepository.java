package com.formation.projetNavette.persistence.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.formation.projetNavette.persistence.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
	
	@Query (value = "SELECT * FROM client WHERE mail=?1 AND telephone=?2" , nativeQuery = true)
	public Client findByMailAndTelephone(String mail, String telephone);

}
