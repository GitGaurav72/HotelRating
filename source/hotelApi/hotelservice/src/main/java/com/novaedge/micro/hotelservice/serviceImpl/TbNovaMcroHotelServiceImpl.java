package com.novaedge.micro.hotelservice.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novaedge.micro.hotelservice.entity.TbNovaMcroHotel;
import com.novaedge.micro.hotelservice.exception.ResoureceNotFoundException;
import com.novaedge.micro.hotelservice.repository.TbNovaMcroHotelRepository;
import com.novaedge.micro.hotelservice.service.TbNovaMcroHotelService;

@Service
public class TbNovaMcroHotelServiceImpl implements TbNovaMcroHotelService{


	@Autowired
    private TbNovaMcroHotelRepository tbNovaMcroHotelRepository;

    @Override
    public List<TbNovaMcroHotel> getAllHotels() {
        return tbNovaMcroHotelRepository.findAll();
    }

    @Override
    public TbNovaMcroHotel getHotelById(String hotel_id) throws ResoureceNotFoundException{
        return tbNovaMcroHotelRepository.findByHotelId(hotel_id);
               
    }


    @Override
    public void deleteHotel(String hotel_id) {
        TbNovaMcroHotel hotel = getHotelById(hotel_id);
        tbNovaMcroHotelRepository.delete(hotel);
    }

	@Override
	public TbNovaMcroHotel createHotel(TbNovaMcroHotel hotel) {
		 hotel.setHotelId(UUID.randomUUID().toString());
		return tbNovaMcroHotelRepository.save(hotel);
	}

	@Override
	public TbNovaMcroHotel updateHotel(String hotel_id, TbNovaMcroHotel hotel) {
        TbNovaMcroHotel existingHotel = getHotelById(hotel_id);
        existingHotel.setName(hotel.getName());
        existingHotel.setLocation(hotel.getLocation());
        existingHotel.setRating(hotel.getRating());
        existingHotel.setAvailableRooms(hotel.getAvailableRooms());
        return tbNovaMcroHotelRepository.save(existingHotel);
	}
}
