package com.rentcom.movie;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.rentcom.movie.data.Movie;
import com.rentcom.movie.data.MovieRepository;

@SpringBootTest
class MovieApplicationTests {

	static Logger log = Logger.getLogger(MovieApplicationTests.class.getName());

	@Autowired
	MovieRepository repository;

	Movie m1, m2;

	@BeforeEach
	public void setUp() {

		//repository.deleteAll();
	

		m1 = repository.save(new Movie("Test Movie 1", "R"));
		m2 = repository.save(new Movie("Test Movie 2", "PG"));
	}

	@Test
	public void setsIdOnSave() {

		Movie m = repository.save(new Movie("Test Movie 1", "R"));
		log.info("Hello There" + this.getClass().getSimpleName());
 
		assertThat(m.id).isNotNull();
	
	}

	@Test
	public void findByTitle() {

		List<Movie> result = repository.findsByTitle("Test Movie 1");

		assertThat(result).hasSize(1).extracting("title").contains("Test Movie 1");
		
	}

	@Test
	public void findsByExample() {

		Movie probe = new Movie(null, "Test Movie 1");

		List<Movie> result = repository.findAll(Example.of(probe));

		assertThat(result).hasSize(2).extracting("title").contains("", "Oliver August");
	}

}
