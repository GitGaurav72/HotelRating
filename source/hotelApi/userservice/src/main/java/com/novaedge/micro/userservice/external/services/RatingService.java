package com.novaedge.micro.userservice.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.novaedge.micro.userservice.entity.TbNovaMcroRating;

@FeignClient(name ="RATING-SERVICE")
public interface RatingService {

	
	
	// Get Ratings By UserId
	@GetMapping("/api/ratings/user/{userId}")
	List<TbNovaMcroRating> getRatingsByUserId (@PathVariable("userId") String userId); 
	
	// Create Rattings
	@PostMapping("/api/ratings/add/rating")
	public ResponseEntity<TbNovaMcroRating> addRating(TbNovaMcroRating ratingModel);
    
    
}
 