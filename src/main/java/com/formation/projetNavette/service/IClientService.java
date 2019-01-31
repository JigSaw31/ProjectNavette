package com.formation.projetNavette.service;




import com.formation.projetNavette.persistence.entity.Client;

public interface IClientService {

	Client findByMailAndTelephone(String mail,String telephone);
	Client save(Client client);
}
