package com.novaedge.micro.hotelservice.service;

import java.util.List;

import com.novaedge.micro.hotelservice.entity.TbNovaMcroHotel;

public interface TbNovaMcroHotelService {
	
    List<TbNovaMcroHotel> getAllHotels();
    TbNovaMcroHotel getHotelById(String hotel_id);
    TbNovaMcroHotel createHotel(TbNovaMcroHotel hotel);
    TbNovaMcroHotel updateHotel(String hotel_id, TbNovaMcroHotel hotel);
    void deleteHotel(String hotel_id);
}
