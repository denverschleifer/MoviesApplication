package edu.cvtc.web.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import edu.cvtc.web.comparator.DirectorComparator;
import edu.cvtc.web.comparator.LengthInMinutesComparator;
import edu.cvtc.web.comparator.MovieTitleComparator;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.util.WorkbookUtility;

/**
 * Servlet implementation class ViewAllController
 */
@WebServlet("/ViewAll")
public class ViewAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String fileName = getServletContext().getRealPath(WorkbookUtility.INPUT_FILE);
		final File inputFile = new File(fileName);
		
		String target = null;
		
		try {
			final List<Movie> movies = WorkbookUtility.retrieveMoviesFromWorkbook(inputFile);
		
			final String sortType = request.getParameter("sortType");
			
			if (sortType != null){
			sortMovies(movies, sortType);
			}
			
			request.setAttribute("movies", movies);
			
			target = "view-all.jsp";
			
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			throw new IOException("The workbook file has an invalid format.");
		}
		
		request.getRequestDispatcher(target).forward(request, response);
		
	}

	private void sortMovies(final List<Movie> movies, final String sortType) {
		switch(sortType) {
		case "movieTitle":
			Collections.sort(movies, new MovieTitleComparator());
			break;
		case "director":
			Collections.sort(movies, new DirectorComparator());
			break;
		case "lengthInMinutes":
			Collections.sort(movies, new LengthInMinutesComparator());
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
