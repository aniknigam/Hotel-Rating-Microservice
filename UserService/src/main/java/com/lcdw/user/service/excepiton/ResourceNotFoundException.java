package com.lcdw.user.service.excepiton;

public class ResourceNotFoundException extends  RuntimeException{
    public  ResourceNotFoundException(){
        super("Resource Not found on server");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
