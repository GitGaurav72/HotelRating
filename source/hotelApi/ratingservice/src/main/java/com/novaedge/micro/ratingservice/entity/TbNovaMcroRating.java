package com.novaedge.micro.ratingservice.entity;

import java.time.LocalDateTime;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("TB_NOVA_MCRO_RATING")
public class TbNovaMcroRating {

    @Id
    private String ratingId;

    private String userId;
    

    private String hotelId;


    private Double rating;


    private String comment;


    private LocalDateTime createdAt;


    private LocalDateTime updatedAt;

	public String getRatingId() {
		return ratingId;
	}

	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public TbNovaMcroRating(String ratingId, String userId, String hotelId, Double rating, String comment,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.ratingId = ratingId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.rating = rating;
		this.comment = comment;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public TbNovaMcroRating() {
		super();
		// TODO Auto-generated constructor stub
	}

    

}
