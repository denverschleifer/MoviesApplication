/**
 * 
 */
package edu.cvtc.web.comparator;

import java.util.Comparator;

import edu.cvtc.web.model.Movie;

/**
 * @author Denver
 *
 */
public class DirectorComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie m1, Movie m2) {
		return m1.getDirector().compareTo(m2.getDirector());
	}

}
