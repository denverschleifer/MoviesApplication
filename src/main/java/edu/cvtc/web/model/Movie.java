/**
 * 
 */
package edu.cvtc.web.model;

import java.io.Serializable;

/**
 * @author Denver
 *
 */
public class Movie implements Serializable {
	
	private static final long serialVersionUID = -7098321328670530203L;
	
	private String movieTitle;
	private String director;
	private Integer lengthInMinutes;
	public Movie(String movieTitle, String director, Integer lengthInMinutes) {
		this.movieTitle = movieTitle;
		this.director = director;
		this.lengthInMinutes = lengthInMinutes;
	}
	
	
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Integer getLengthInMinutes() {
		return lengthInMinutes;
	}
	public void setLengthInMinutes(Integer lengthInMinutes) {
		this.lengthInMinutes = lengthInMinutes;
	}


	@Override
	public String toString() {
		return "Movie [movieTitle=" + movieTitle + ", director=" + director + ", lengthInMinutes=" + lengthInMinutes
				+ "]";
	}
	
	
	
	
}
