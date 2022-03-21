package com.rentcom.customer;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.logging.Logger;

//import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
//import org.springframework.test.context.junit4.SpringRunner;

import com.rentcom.customer.data.Customer;
import com.rentcom.customer.data.CustomerRepository;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerApplicationTests {

	@Test
	public void contextLoads() {
	}
	static Logger log = Logger.getLogger(CustomerApplicationTests.class.getName());

	@Autowired
	CustomerRepository repository;

	Customer dave, oliver, carter;

	@BeforeEach
	public void setUp() {

		repository.deleteAll();

		dave = repository.save(new Customer("Dave", "Matthews"));
		oliver = repository.save(new Customer("Oliver August", "Matthews"));
		carter = repository.save(new Customer("Carter", "Beauford"));
	}

	@Test
	public void setsIdOnSave() {

		Customer dave = repository.save(new Customer("Dave", "Matthews"));
		log.info("Hello There" + this.getClass().getSimpleName());

		assertThat(dave.id).isNotNull();
	
	}

	@Test
	public void findsByLastName() {

		List<Customer> result = repository.findByLastName("Beauford");

		assertThat(result).hasSize(1).extracting("firstName").contains("Carter");
		
	}

	@Test
	public void findsByExample() {

		Customer probe = new Customer(null, "Matthews");

		List<Customer> result = repository.findAll(Example.of(probe));

		assertThat(result).hasSize(2).extracting("firstName").contains("Dave", "Oliver August");
	}

}
