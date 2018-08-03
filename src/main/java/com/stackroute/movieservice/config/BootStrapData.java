package com.stackroute.movieservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;

//@Configuration
public class BootStrapData implements ApplicationListener<ContextRefreshedEvent>{

	private MovieRepository movieRepository;
	
	@Autowired
	public BootStrapData(MovieRepository movieRepository) {
		this.movieRepository=movieRepository;
		
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Movie movie=new Movie();
		movie.setMovieTitle("Conjuring");
		movieRepository.save(movie);
		Movie testMovie = Movie.builder()
				 .movieTitle("conjuring")
				 .build();
		movieRepository.save(testMovie);
	}

}
