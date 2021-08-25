package com.natwest.client.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.client.exception.ClientAlreadyExistException;
import com.natwest.client.exception.ClientNotExistException;
import com.natwest.client.model.Client;
import com.natwest.client.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {

	@Autowired
	ClientService clientService;

	@RequestMapping("/addClient")
	public ResponseEntity<?> addClient(@RequestBody Client client) {
		Client resultobj;
		try {
			client.setDate(LocalDate.now());
			client.setNumberOfRecruit(0);
			resultobj = this.clientService.addClient(client);
			return new ResponseEntity<Client>(resultobj, HttpStatus.CREATED);

		} catch (ClientAlreadyExistException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

		}
	}

	@RequestMapping("/getAllClient")
	public ResponseEntity<?> getClient() {
		List<Client> clients = this.clientService.getAllClient();
		return new ResponseEntity<List>(clients, HttpStatus.OK);

	}

	@RequestMapping("/deleteClient/{sourceName}")
	public ResponseEntity deleteClients(@PathVariable("sourceName") String sourceName) {

		try {
			boolean ans = this.clientService.deleteClient(sourceName);
		} catch (ClientNotExistException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<String>("Client deleted Successfully", HttpStatus.OK);

	}

	@RequestMapping("/updateClient")
	public ResponseEntity updateClient(@RequestBody Client client) {
		try {
			boolean ans = this.clientService.updateClient(client);
		} catch (ClientNotExistException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<String>("Client updated Successfully", HttpStatus.OK);

	}

	@RequestMapping("/incrementNumberOfRecruiter/{sourceName}")
	public ResponseEntity incrementNumOfRecruits(@PathVariable("sourceName") String sourceName) {
		try {
			boolean ans = this.clientService.incrementNumberOfRecruits(sourceName);
		} catch (ClientNotExistException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<String>("Number of Recruits incremented Successfully", HttpStatus.OK);

	}

}
