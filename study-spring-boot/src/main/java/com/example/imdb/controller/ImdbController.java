package com.example.imdb.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.imdb.domain.Movie;
import com.example.imdb.service.MovieService;

@RestController
@RequestScope
@RequestMapping("movies")
@CrossOrigin
public class ImdbController {
	@Autowired private MovieService movieSrv;
	// GET http://localhost:7001/imdb/api/v1/movies?from=1970&to=1979 
	// query parameters are "from" and "to"
	@GetMapping(params = {"from", "to"})
	public Collection<Movie> getMoviesByYearRange(
			@RequestParam(name = "from") int fromYear,
			@RequestParam(name = "to") int toYear){
		return movieSrv.findAllMoviesByYearRange(fromYear, toYear);
	}
}
