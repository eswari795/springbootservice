package com.stackroute.movieservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Configuration;
import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;

@Component
public class BootStrapCommandLineRunner implements CommandLineRunner {
	private MovieRepository movieRepository;

	@Autowired
	public BootStrapCommandLineRunner(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Movie movie = new Movie();
		movie.setMovieTitle("conjuring");
		movieRepository.save(movie);
		Movie testMovie = Movie.builder().movieTitle("annabelle").movieRating(10).build();
		movieRepository.save(testMovie);

	}
}
