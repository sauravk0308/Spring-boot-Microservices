package io.movieinfoservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@Value("${api.key}")
	private String apiKkey;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping("/{movieId}")
	public Movie getMoiveInfo(@PathVariable("movieId") String movieId) {
		
		//MovieSummary movieSummary =  restTemplate.getForObject("http://rating-data-service/ratingsdata/users/" +movieId, MovieSummary.class);
		
		return new Movie(movieId, "Test name");
	}
}
