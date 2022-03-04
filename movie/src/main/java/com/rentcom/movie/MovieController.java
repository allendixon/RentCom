package com.rentcom.movie;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rentcom.movie.data.CustomerRepository;
import com.rentcom.movie.data.Customer;

@RestController
public class MovieController {
	  private final CustomerRepository repository;

	  MovieController(CustomerRepository repository) {
	    this.repository = repository;
	  }


	  // Aggregate root
	  // tag::get-aggregate-root[]
	  @GetMapping("/customer")
	  List<Customer> all() {
	    return repository.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping("/customer")
	  Customer newCustomer(@RequestBody Customer newCustomer) {
	    return repository.save(newCustomer);
	  }

	  // Single item
	  
	  @GetMapping("/customer/{id}")
	  Customer one(@PathVariable String id) {
	    
	    return repository.findById(id)
	      .orElseThrow(() -> new CustomerNotFoundException(id));
	  }

	  @PutMapping("/customer/{id}")
	  Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable String id) {
	    
	    return repository.findById(id)
	      .map(customer -> {
	    	  customer.setFirstName(newCustomer.getFirstName());
	    	  
	    	  customer.setLastName(newCustomer.getLastName());
	        return repository.save(customer);
	      })
	      .orElseGet(() -> {
	    	  newCustomer.id = id;
	        return repository.save(newCustomer);
	      });
	  }

	  @DeleteMapping("/customer/{id}")
	  void deleteCustomer(@PathVariable String id) {
	    repository.deleteById(id);
	  }
}
