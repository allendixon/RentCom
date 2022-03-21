package com.rentcom.movie.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface MovieRepository extends MongoRepository<Movie, String> {

	public List<Movie> findsByTitle(String title);
	public List<Movie> findsByRated(String rated);

}
