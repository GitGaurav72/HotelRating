package com.novaedge.micro.userservice.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import com.novaedge.micro.userservice.entity.TbNovaMcroHotel;

@FeignClient(name ="HOTEL-SERVICE")
public interface HotelService {

	
	@GetMapping("api/v1/hotels/{hotelId}")
	TbNovaMcroHotel getHotel(@PathVariable("hotelId") String hotelId); 
	
}
