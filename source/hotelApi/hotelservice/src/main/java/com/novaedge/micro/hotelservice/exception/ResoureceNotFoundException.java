package com.novaedge.micro.hotelservice.exception;

public class ResoureceNotFoundException extends RuntimeException{
	
	public ResoureceNotFoundException () {
		super("Resourece Not Found on Serve !!");
	}
	
	public ResoureceNotFoundException (String message) {
		super(message);
	}

}
