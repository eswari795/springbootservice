package com.stackroute.movieservice.services;

import java.util.List;
import java.util.Optional;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;

public interface MovieService {

	public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;
	public List<Movie> getAllMovies();
	public List<Movie> getByMovieName(String title) ;
//	public Movie updateMovie(Movie movie);
	public boolean deleteMovie(int movieId) throws MovieNotFoundException;
	public List<Movie> getByMovieNameQuery(String title);
}
