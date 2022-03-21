package com.rentcom.movie.data;

import org.springframework.data.annotation.Id;
import javax.persistence.*;

@Entity
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
				"Movie[id=%s, title='%s', rated='%s']",
				id, title, rated);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

}
