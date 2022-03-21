package com.rentcom.movie;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rentcom.movie.data.MovieRepository;
import com.rentcom.movie.data.Movie;

@RestController
public class MovieController {
	  private final MovieRepository repository;

	  MovieController(MovieRepository repository) {
	    this.repository = repository;
	  }


	  // Aggregate root
	  // tag::get-aggregate-root[]
	  @GetMapping("/movie")
	  List<Movie> all() {
	    return repository.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping("/movie")
	  Movie newMovie(@RequestBody Movie newMovie) {
	    return repository.save(newMovie);
	  }

	  // Single item
	  
	  @GetMapping("/movie/{id}")
	  Movie one(@PathVariable String id) {
	    
	    return repository.findById(id)
	      .orElseThrow(() -> new MovieNotFoundException(id));
	  }

	  @PutMapping("/movie/{id}")
	  Movie replaceMovie(@RequestBody Movie newMovie, @PathVariable String id) {
	    
	    return repository.findById(id)
	      .map(movie -> {
	    	  movie.setTitle(newMovie.getTitle());
	    	  
	    	  movie.setRated(newMovie.getRated());
	        return repository.save(movie);
	      })
	      .orElseGet(() -> {
	    	  newMovie.id = id;
	        return repository.save(newMovie);
	      });
	  }

	  @DeleteMapping("/movie/{id}")
	  void deleteMovie(@PathVariable String id) {
	    repository.deleteById(id);
	  }
}
