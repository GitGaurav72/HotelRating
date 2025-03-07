package com.novaedge.micro.ratingservice.repository;



import com.novaedge.micro.ratingservice.entity.TbNovaMcroRating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TbNovaMcroRatingRepository extends MongoRepository<TbNovaMcroRating, String> {

    List<TbNovaMcroRating> findByUserId(String userId);
    List<TbNovaMcroRating> findByHotelId(String hotelId);
    
}

