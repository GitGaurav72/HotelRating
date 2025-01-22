package com.novaedge.micro.userservice.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class TbNovaMcroRating {

	private String ratingId;
	private String userid;
	private String hotelId;
	private int rating;
	private String comment;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt; 
	
	
	public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
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
	public TbNovaMcroRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TbNovaMcroRating(String ratingId, String userid, String hotelId, int rating, String comment,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.ratingId = ratingId;
		this.userid = userid;
		this.hotelId = hotelId;
		this.rating = rating;
		this.comment = comment;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
}
