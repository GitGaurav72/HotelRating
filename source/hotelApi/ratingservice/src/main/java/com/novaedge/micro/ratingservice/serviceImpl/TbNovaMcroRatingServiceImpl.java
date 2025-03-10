package com.novaedge.micro.ratingservice.serviceImpl;

import com.novaedge.micro.ratingservice.entity.TbNovaMcroRating;
import com.novaedge.micro.ratingservice.repository.TbNovaMcroRatingRepository;
import com.novaedge.micro.ratingservice.service.TbNovaMcroRatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TbNovaMcroRatingServiceImpl implements TbNovaMcroRatingService {

    @Autowired
    private TbNovaMcroRatingRepository ratingRepository;

    @Override
    public TbNovaMcroRating addRating(TbNovaMcroRating ratingModel) {
        TbNovaMcroRating rating = new TbNovaMcroRating();
        rating.setUserId(ratingModel.getUserId());
        rating.setHotelId(ratingModel.getHotelId());
        rating.setRating(ratingModel.getRating());
        rating.setComment(ratingModel.getComment());
        TbNovaMcroRating savedRating = ratingRepository.save(rating);
        return mapToModel(savedRating);
    }

    @Override
    public TbNovaMcroRating getRatingById(String ratingId) {
        TbNovaMcroRating rating = ratingRepository.findById(ratingId)
                .orElseThrow(() -> new RuntimeException("Rating not found for ID: " + ratingId));
        return mapToModel(rating);
    }

    @Override
    public List<TbNovaMcroRating> getRatingsByUserId(String userId) {
        return ratingRepository.findByUserId(userId)
                .stream()
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<TbNovaMcroRating> getAllRatings() {
        return ratingRepository.findAll()
                .stream()
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }

    @Override
    public TbNovaMcroRating updateRating(String ratingId, TbNovaMcroRating ratingModel) {
        TbNovaMcroRating rating = ratingRepository.findById(ratingId)
                .orElseThrow(() -> new RuntimeException("Rating not found for ID: " + ratingId));
        rating.setRating(ratingModel.getRating());
        rating.setComment(ratingModel.getComment());
        TbNovaMcroRating updatedRating = ratingRepository.save(rating);
        return mapToModel(updatedRating);
    }

    @Override
    public void deleteRating(String ratingId) {
        if (!ratingRepository.existsById(ratingId)) {
            throw new RuntimeException("Rating not found for ID: " + ratingId);
        }
        ratingRepository.deleteById(ratingId);
    }

    private TbNovaMcroRating mapToModel(TbNovaMcroRating rating) {
        TbNovaMcroRating model = new TbNovaMcroRating();
        model.setRatingId(rating.getRatingId());
        model.setUserId(rating.getUserId());
        model.setHotelId(rating.getHotelId());
        model.setRating(rating.getRating());
        model.setComment(rating.getComment());
        model.setCreatedAt(rating.getCreatedAt());
        model.setUpdatedAt(rating.getUpdatedAt());
        return model;
    }

	@Override
	public List<TbNovaMcroRating> getRatingByHotelId(String hotelId) {
		
	       return ratingRepository.findByHotelId(hotelId)
	                .stream()
	                .map(this::mapToModel)
	                .collect(Collectors.toList());

	}
}
