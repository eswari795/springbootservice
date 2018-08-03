package com.stackroute.movieservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.repository.MovieRepository;
import com.stackroute.movieservice.services.MovieService;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

	MovieService movieService;
	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService=movieService;
	}
	@RequestMapping("/")
	public String getMsgHandler() {
		return "Hello";
	}
	@RequestMapping(value="/movie",method=RequestMethod.POST)
	public ResponseEntity<?> saveMovieHandler(@RequestBody Movie movie){
		try {
		Movie movieObj=movieService.saveMovie(movie);
		return new ResponseEntity<Movie>(movieObj, HttpStatus.OK);
		}catch(MovieAlreadyExistsException e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.ALREADY_REPORTED);	
		}
	}
	@RequestMapping(value="/movies",method=RequestMethod.GET)
	public String getAllMoviesHandler() {
		return movieService.getAllMovies().toString();
	}
	@RequestMapping(value="/movie/{movieId}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteMovieHandler(@PathVariable("movieId") int id){
		try {
			return new ResponseEntity<>(movieService.deleteMovie(id),HttpStatus.OK);
		}catch(MovieNotFoundException e){
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	@RequestMapping(value="/moviesbytitle/{movieTitle}",method=RequestMethod.GET)
	public String getMoviesByTitleHandler(@PathVariable("movieTitle") String title){
		
		List<Movie> movieList=movieService.getByMovieName(title);
		return movieList.toString();
	}
	@RequestMapping(value="/moviesbyname/{movieTitle}",method=RequestMethod.GET)
	public List<Movie> getMoviesByNameHandler(@PathVariable("movieTitle") String title) {
		return movieService.getByMovieName(title);
	}
}
