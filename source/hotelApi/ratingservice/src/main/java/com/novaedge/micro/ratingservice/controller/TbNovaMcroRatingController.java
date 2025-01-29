package com.novaedge.micro.ratingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.novaedge.micro.ratingservice.entity.TbNovaMcroRating;
import com.novaedge.micro.ratingservice.service.TbNovaMcroRatingService;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class TbNovaMcroRatingController {

    @Autowired
    private TbNovaMcroRatingService ratingService;

    
    // Add New Rating
    @PostMapping("/add/rating")
    public ResponseEntity<TbNovaMcroRating> addRating(@RequestBody TbNovaMcroRating ratingModel) {
        return ResponseEntity.ok(ratingService.addRating(ratingModel));
    }

    // Get rating By id
    @GetMapping("/{ratingId}")
    public ResponseEntity<TbNovaMcroRating> getRatingById(@PathVariable String ratingId) {
        return ResponseEntity.ok(ratingService.getRatingById(ratingId));
    }

    // Get all ratings by userid
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TbNovaMcroRating>> getRatingsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
    }
    
    //Get Rating by HotelId
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<TbNovaMcroRating>> getRatingByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

    //Get All Ratings
    @GetMapping
    public ResponseEntity<List<TbNovaMcroRating>> getAllRatings() {
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    // Update ratings
    @PutMapping("/{ratingId}")
    public ResponseEntity<TbNovaMcroRating> updateRating(@PathVariable String ratingId,
                                                              @RequestBody TbNovaMcroRating ratingModel) {
        return ResponseEntity.ok(ratingService.updateRating(ratingId, ratingModel));
    }

    //  Delete Ratings
    @DeleteMapping("/{ratingId}")
    public ResponseEntity<Void> deleteRating(@PathVariable String ratingId) {
        ratingService.deleteRating(ratingId);
        return ResponseEntity.noContent().build();
    }
}
