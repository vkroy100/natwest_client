package com.natwest.client.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natwest.client.exception.ClientAlreadyExistException;
import com.natwest.client.exception.ClientNotExistException;
import com.natwest.client.model.Client;
import com.natwest.client.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepo;

	@Override
	public Client addClient(Client obj) throws ClientAlreadyExistException {

		Optional<Client> clientobj = clientRepo.findById(obj.getSourceName());

		if (clientobj.isPresent()) {
			throw new ClientAlreadyExistException("There is already a client with this sourcename");
		} else {
			clientRepo.save(obj);
			return obj;
		}
	}

	@Override
	public boolean deleteClient(String sourceName) throws ClientNotExistException {
		Optional<Client> clientobj = clientRepo.findById(sourceName);

		if (!clientobj.isPresent()) {
			throw new ClientNotExistException("There doesn't exist any client with this sourcename");
		} else {
			clientRepo.deleteById(sourceName);
			return true;
		}
	}

	@Override
	public boolean updateClient(Client client) throws ClientNotExistException {

		Optional<Client> clientobj = clientRepo.findById(client.getSourceName());
		if (!clientobj.isPresent()) {
			throw new ClientNotExistException("There doesn't exist any client with this sourcename");
		} else {
			Client obj = clientobj.get();
			obj.setCostPerCadet(client.getCostPerCadet());
			obj.setWebsiteAddress(client.getWebsiteAddress());
			clientRepo.save(obj);
			return true;
		}

	}

	@Override
	public boolean incrementNumberOfRecruits(String sourceName) throws ClientNotExistException {

		Optional<Client> clientobj = clientRepo.findById(sourceName);
		if (!clientobj.isPresent()) {
			throw new ClientNotExistException("There doesn't exist any client with this sourcename");
		} else {
			Client obj = clientobj.get();
			obj.setNumberOfRecruit(obj.getNumberOfRecruit() + 1);
			clientRepo.save(obj);
			return true;
		}

	}

	@Override
	public List<Client> getAllClient() {
		return clientRepo.findAll();
	}

}
