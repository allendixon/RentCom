package com.rentcom.movie.data;

import org.springframework.data.annotation.Id;
public class Movie {

	@Id
	public String id;

	public String title;
	public String rated;
	

	public Movie() {}

	public Movie(String title, String rated) {
		this.title = title;
		this.rated = rated;
	}

	@Override
	public String toString() {
		return String.format(
				"Customer[id=%s, title='%s', rated='%s']",
				id, title, rated);
	}
}
