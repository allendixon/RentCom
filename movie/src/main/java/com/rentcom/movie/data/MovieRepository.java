package com.rentcom.movie.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface MovieRepository extends MongoRepository<Movie, String> {

	public Movie findByTitle(String title);
	public List<Movie> findByRated(String rated);

}
