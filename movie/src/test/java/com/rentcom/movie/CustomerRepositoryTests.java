package com.rentcom.movie;
/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.assertj.core.api.Assertions.*;

//import org.apache.logging.log4j.*;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.rentcom.movie.data.Customer;
import com.rentcom.movie.data.CustomerRepository;

@SpringBootTest
public class CustomerRepositoryTests {
	static Logger log = Logger.getLogger(CustomerRepositoryTests.class.getName());

	@Autowired
	CustomerRepository repository;

	Customer dave, oliver, carter;

	@BeforeEach
	public void setUp() {

		//repository.deleteAll();
	

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
