package com.workshop.web.error;

public class CountryNotFoundException extends RuntimeException{

    public CountryNotFoundException (String message) {
        super(message);
    }

}
