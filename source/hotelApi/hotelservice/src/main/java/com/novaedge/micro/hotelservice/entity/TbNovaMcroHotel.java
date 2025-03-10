package com.novaedge.micro.hotelservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_NOVA_MCRO_HOTEL")
public class TbNovaMcroHotel {

    @Id
    @Column(name = "HOTEL_ID")
    private String hotelId;

    @Column(name = "HOTEL_NAME", nullable = false)
    private String name;

    @Column(name = "LOCATION", nullable = false)
    private String location;

    @Column(name = "RATING")
    private Double rating;

    @Column(name = "AVAILABLE_ROOMS")
    private Integer availableRooms;

    // Getters and Setters
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