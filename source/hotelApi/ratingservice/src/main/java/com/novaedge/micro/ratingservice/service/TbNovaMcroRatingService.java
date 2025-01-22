package com.novaedge.micro.ratingservice.service;

import java.util.List;

import com.novaedge.micro.ratingservice.entity.TbNovaMcroRating;

public interface TbNovaMcroRatingService {

    TbNovaMcroRating addRating(TbNovaMcroRating ratingModel);

    TbNovaMcroRating getRatingById(String ratingId);

    List<TbNovaMcroRating> getRatingsByUserId(String userId);

    List<TbNovaMcroRating> getAllRatings();

    TbNovaMcroRating updateRating(String ratingId, TbNovaMcroRating ratingModel);

    void deleteRating(String ratingId);

	List<TbNovaMcroRating> getRatingByHotelId(String hotelId);
}
