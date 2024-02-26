package com.lcdw.hotel.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String notFound) {
        super(notFound);
    }

    public ResourceNotFoundException(){
        super("Data Not Found");
    }
}
