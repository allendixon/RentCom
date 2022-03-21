package com.rentcom.customer.data;

import java.util.List;

/*  
 *   I am using JPA for Mongo.  Why write a lot of CRUDy code when there is no need?
 */

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	public Customer findByFirstName(String firstName);
	public List<Customer> findByLastName(String lastName);

}
