package com.stackroute.movieservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.repository.MovieRepository;
@Service
public class MovieServiceImpl implements MovieService{

	MovieRepository movieRepository;
	@Autowired
	public  MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository=movieRepository;
	}
	@Override
	public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException{
		if(!(movieRepository.existsById(movie.getMovieId()))) {
		Movie movieObj=movieRepository.save(movie);
		return movieObj;
		}
		else {
			throw new MovieAlreadyExistsException("Movie already exists");
		}
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> list=(List<Movie>) movieRepository.findAll();
		return list;
	}

	@Override
	public String toString() {
		return movieRepository.toString();
	}
//	@Override
//	public Movie getMovieById(int movieId) {
//		Movie movieObj=movieRepository.
//		return null;
//	}
//	@Override
//	public Movie updateMovie(Movie movie) {
//		Movie movieObj=movieRepository.
//		return null;
//	}
	@Override
	public boolean deleteMovie(int movieId) throws MovieNotFoundException {
		boolean result;
		if(movieRepository.existsById(movieId)==true) {
			movieRepository.deleteById(movieId);
			return result=true;
			
		}
		else {
			throw new MovieNotFoundException("Movie not found");
		}
		
		
		
	}
	@Override
	public List<Movie> getByMovieName(String title) {
		
		List<Movie> movieList;
		
		movieList=movieRepository.getByMovieTitle(title);
		
		return movieList;
	}
	@Override
	public List<Movie> getByMovieNameQuery(String title) {
		List<Movie> movieList=movieRepository.getByMovieName(title);
		return movieList;
	}
	
	
}
