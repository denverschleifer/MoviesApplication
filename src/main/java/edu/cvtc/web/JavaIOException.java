/**
 * 
 */
package edu.cvtc.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import edu.cvtc.web.model.Movie;
import edu.cvtc.web.util.WorkbookUtility;

/**
 * @author Denver
 *
 */
public class JavaIOException {
	
	private static final String INPUT_FILE = "/assets/movieApplicationExcel.xlsx";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final File inputFile = new File(INPUT_FILE);
		
		try {
			final List<Movie> movies = WorkbookUtility.retrieveMoviesFromWorkbook(inputFile);
			for (final Movie movie : movies) {
				System.out.println(movie);
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
