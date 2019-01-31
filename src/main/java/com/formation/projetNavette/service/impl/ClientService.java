package com.formation.projetNavette.service.impl;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.projetNavette.persistence.entity.Client;
import com.formation.projetNavette.persistence.repository.ClientRepository;
import com.formation.projetNavette.service.IClientService;

@Service
@Transactional
public class ClientService implements IClientService{

	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public Client findByMailAndTelephone(String mail, String telephone) {

		Client client= clientRepository.findByMailAndTelephone(mail,telephone);
		return client;
	}
//	else { throw new NotFoundException("LE LOGIN OU LE MOT DE PASSE N'EXISTE PAS!" );}

	@Override
	public Client save(Client client) {
		return clientRepository.save(client);
	}
	


}
