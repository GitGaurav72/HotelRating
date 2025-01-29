package com.novaedge.micro.userservice.serviceImpl;

import com.novaedge.micro.userservice.entity.TbNovaMcroHotel;
import com.novaedge.micro.userservice.entity.TbNovaMcroRating;
import com.novaedge.micro.userservice.entity.TbNovaMcroUser;
import com.novaedge.micro.userservice.exception.ResoureceNotFoundException;
import com.novaedge.micro.userservice.external.services.HotelService;
import com.novaedge.micro.userservice.external.services.RatingService;
import com.novaedge.micro.userservice.repository.TbNovaMcroUserRepository;
import com.novaedge.micro.userservice.service.TbNovaMcroUserService;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TbNovaMcroUserServiceImpl implements TbNovaMcroUserService {

	@Autowired
	private TbNovaMcroUserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;

	@Autowired
	private RatingService ratingService;

	private Logger logger = LoggerFactory.getLogger(TbNovaMcroUserServiceImpl.class);

	// Create or update a user
	@Override
	public TbNovaMcroUser saveUser(TbNovaMcroUser user) {
		user.setUserId(UUID.randomUUID().toString());
		return userRepository.save(user);
	}

	// Find user by ID
	@Override
	public TbNovaMcroUser getUserById(String userId) {
		TbNovaMcroUser tbNovaMcroUser = userRepository.findByUserId(userId).orElseThrow(
				() -> new ResoureceNotFoundException("User with given id is not present on server !! :" + userId));
//    	TbNovaMcroRating[] forObject = restTemplate.getForObject("http://RATING-SERVICE/api/ratings/user/"+tbNovaMcroUser.getUserId(), TbNovaMcroRating[].class);
//    	List<TbNovaMcroRating> ratings = Arrays.stream(forObject).toList();
//    	logger.info("{}",forObject);

		List<TbNovaMcroRating> ratings = ratingService.getRatingsByUserId(tbNovaMcroUser.getUserId());

		List<TbNovaMcroRating> ratingList = ratings.stream().map(rating -> {
			System.out.println(rating.getHotelId());
			// http://192.168.13.205:8082/api/v1/hotels
//    		ResponseEntity<TbNovaMcroHotel>  forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/api/v1/hotels/"+rating.getHotelId(), TbNovaMcroHotel.class);
//    		TbNovaMcroHotel tbNovaMcroHotel = forEntity.getBody();
//    		rating.setHotel(tbNovaMcroHotel);

			TbNovaMcroHotel hotelEntity = hotelService.getHotel(rating.getHotelId());

			rating.setHotel(hotelEntity);
			return rating;
		}).collect(Collectors.toList());

		tbNovaMcroUser.setRatings(ratingList);

		return tbNovaMcroUser;
	}

	// Find all users
	@Override
	public List<TbNovaMcroUser> getAllUsers() {
		return userRepository.findAll();
	}

	// Delete user by ID
	@Override
	public void deleteUser(String userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public ResponseEntity<TbNovaMcroRating> addRating(String userId, String hotelId, TbNovaMcroRating tbNovaMcroRating) {
 
		tbNovaMcroRating.setUserId(userId);
		tbNovaMcroRating.setHotelId(hotelId);
		
		ResponseEntity<TbNovaMcroRating>   response  = ratingService.addRating(tbNovaMcroRating);
		return response;
	}
}
