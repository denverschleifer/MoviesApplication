package edu.cvtc.web.dao.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.util.DBUtility;
import edu.cvtc.web.util.WorkbookUtility;

public class MovieDaoImpl implements MovieDao {

	private static final String SELECT_ALL_FROM_MOVIE = "select * from movie;";
	private static final String DROP_TABLE_MOVIE = "drop table if exists movie;";
	private static final String CREATE_TABLE_MOVIE = "create table movie (id integer primary key autoincrement, movieTitle text, director text, lengthInMinutes integer);";

	@Override
	public void populate(final String filePath) throws MovieDaoException{

		Connection connection = null;
		Statement statement = null;
		

		try {

			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			statement.executeUpdate(DROP_TABLE_MOVIE);
			statement.executeUpdate(CREATE_TABLE_MOVIE);
			
			final File inputFile = new File(filePath);
			final List<Movie> movies = WorkbookUtility.retrieveMoviesFromWorkbook(inputFile);
			
			for(final Movie movie : movies) {
				final String insertValues = "insert into movie (movieTitle, director, lengthInMinutes) "
						+ "values (\"" + movie.getMovieTitle() + "\","
								+ "\"" + movie.getDirector() + "\", "
										+ movie.getLengthInMinutes() + ");";
				
				System.out.println(insertValues); // NOTES: Log message to Console so we can see data being added to database.
				
				statement.executeUpdate(insertValues);
				
			}
			
			
		} catch (ClassNotFoundException | SQLException | InvalidFormatException | IOException e) {
			e.printStackTrace();
			throw new MovieDaoException("Error: unable to populate database.");
		} finally {
			DBUtility.closeConnection(connection, statement);
		}

	}

	@Override
	public List<Movie> retrieveMovie() throws MovieDaoException {
		
		Connection connection = null;
		Statement statement = null;
		
		final List<Movie> movies = new ArrayList<>();
		
		try {
			
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_MOVIE);
			
			while (resultSet.next()) {
				final String movieTitle = resultSet.getString("movieTitle");
				final String director = resultSet.getString("director");
				final int lengthInMinutes = resultSet.getInt("lengthInMinutes");
				
				movies.add(new Movie(movieTitle, director, lengthInMinutes));

			}
			
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
			throw new MovieDaoException("Error: Unable to retrieve movies.");
		} finally {
			DBUtility.closeConnection(connection, statement);
		}
		
		return movies;
	}

	@Override
	public void insertMovie(final Movie movie) throws MovieDaoException {

		Connection connection = null;
		PreparedStatement insertStatement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			
			final String sqlStatement = "insert into movie (movieTitle, director, lengthInMinutes) values (?,?,?);";
			
			insertStatement = connection.prepareStatement(sqlStatement);
			
			insertStatement.setString(1, movie.getMovieTitle());
			insertStatement.setString(2, movie.getDirector());
			insertStatement.setInt(3, movie.getLengthInMinutes());
			
			
			insertStatement.setQueryTimeout(DBUtility.TIMEOUT);
			
			insertStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new MovieDaoException("Error: Unable to add this movie to the database.");
		} finally {
			DBUtility.closeConnection(connection, insertStatement);
		}
		
	}

}