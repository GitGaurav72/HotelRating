package com.novaedge.micro.userservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class TbNovaMcroHotel {

	private String hotelId;

	private String name;

	private String location;

	private Double rating;

	private Integer availableRooms;

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getAvailableRooms() {
		return availableRooms;
	}

	public void setAvailableRooms(Integer availableRooms) {
		this.availableRooms = availableRooms;
	}

	public TbNovaMcroHotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TbNovaMcroHotel(String hotelId, String name, String location, Double rating, Integer availableRooms) {
		super();
		this.hotelId = hotelId;
		this.name = name;
		this.location = location;
		this.rating = rating;
		this.availableRooms = availableRooms;
	}
	
	
	
}
