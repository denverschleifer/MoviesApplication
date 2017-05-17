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
public class MovieTitleComparator implements Comparator<Movie> {

	@Override
	public int compare(final Movie m1, final Movie m2) {
		return m1.getMovieTitle().compareTo(m2.getMovieTitle());
	}

}
