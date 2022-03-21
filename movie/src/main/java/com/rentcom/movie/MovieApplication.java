package com.rentcom.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rentcom.movie.data.MovieRepository;
import com.rentcom.movie.data.Movie;


@SpringBootApplication
public class MovieApplication implements CommandLineRunner {

	@Autowired
	private MovieRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		// fetch an individual move
		System.out.println("Movie found with findByTitle('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findsByTitle("Test"));

		System.out.println("Movies found with findAll('):");
		System.out.println("--------------------------------");
		for (Movie movie : repository.findAll()) {
			System.out.println(movie);
		}
	}
}
