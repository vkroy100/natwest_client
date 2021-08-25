package com.natwest.client.service;

import java.util.List;

import com.natwest.client.exception.ClientAlreadyExistException;
import com.natwest.client.exception.ClientNotExistException;
import com.natwest.client.model.Client;

public interface ClientService {

	List<Client> getAllClient();

	Client addClient(Client obj) throws ClientAlreadyExistException;

	boolean deleteClient(String sourceName) throws ClientNotExistException;

	boolean updateClient(Client client) throws ClientNotExistException;

	boolean incrementNumberOfRecruits(String sourceName) throws ClientNotExistException;

}
