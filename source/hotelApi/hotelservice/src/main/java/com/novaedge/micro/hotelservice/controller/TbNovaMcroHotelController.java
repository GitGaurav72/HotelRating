package com.novaedge.micro.hotelservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novaedge.micro.hotelservice.entity.TbNovaMcroHotel;
import com.novaedge.micro.hotelservice.service.TbNovaMcroHotelService;

@RestController
@RequestMapping("/api/v1/hotels")
public class TbNovaMcroHotelController {

	@Autowired
    private TbNovaMcroHotelService tbNovaMcroHotelService;

    // Endpoint to retrieve all hotels
    @GetMapping
    public List<TbNovaMcroHotel> getAllHotels() {
        return tbNovaMcroHotelService.getAllHotels();
    }

    // Endpoint to retrieve a hotel by ID
    @GetMapping("/{hotelId}")
    public TbNovaMcroHotel getHotelById(@PathVariable("hotelId") String hotel_id) {
        return tbNovaMcroHotelService.getHotelById(hotel_id);
    }

    // Endpoint to create a new hotel
    @PostMapping
    public TbNovaMcroHotel createHotel(@RequestBody TbNovaMcroHotel hotel) {
        return tbNovaMcroHotelService.createHotel(hotel);
    }

    // Endpoint to update an existing hotel
    @PutMapping("/{hotelId}")
    public TbNovaMcroHotel updateHotel(@PathVariable("hotelId") String hotel_id, @RequestBody TbNovaMcroHotel hotel) {
        return tbNovaMcroHotelService.updateHotel(hotel_id, hotel);
    }

    // Endpoint to delete a hotel
    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Void> deleteHotel(@PathVariable("hotelId") String hotel_id) {
    	tbNovaMcroHotelService.deleteHotel(hotel_id);
        return ResponseEntity.noContent().build();
    }
}
