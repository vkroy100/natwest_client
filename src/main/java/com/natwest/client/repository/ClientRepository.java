package com.natwest.client.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.natwest.client.model.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

}
