package com.stackroute.movieservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.movieservice.domain.Movie;
@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer>{
	public List<Movie> getByMovieTitle(String MovieTitle);
	@Query(value="Select movie from Movie movie where movie.movieTitle=:movieName")
	public List<Movie> getByMovieName(@Param("movieName") String name );
}
