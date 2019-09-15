package io.moviecatalogservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.discovery.DiscoveryClient;

import io.moviecatalogservice.model.CatalogItem;
import io.moviecatalogservice.model.Movie;
import io.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	
/*	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private WebClient.Builder webClientBuilder;*/
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

		//RestTemplate restTemplate = new RestTemplate();
		/*List<Rating> ratings = Arrays.asList(
					new Rating("1234", 4), 
					new Rating("5678", 3)
				);*/
		
		UserRating ratings =  restTemplate.getForObject("http://rating-data-service/ratingsdata/users/" +userId, UserRating.class);
		
		return ratings.getUserRating().stream().map(rating -> {
			
			//For each movie ID, call movie infor service and get details
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" +rating.getMovieId(), Movie.class);
			/*
			Movie movie =   webClientBuilder.build()
						.get()
						.uri("http://localhost:8082/movies/" +rating.getMovieId())
						.retrieve()
						.bodyToMono(Movie.class)
						.block();*/
			
			System.out.println("Movie Name "+movie.getName());
			return new CatalogItem(movie.getName(), "Test", rating.getRating());
		}).collect(Collectors.toList());
		
	}
}
