package com.OnitoTechnologies.Assessment.Exception;

public class MovieAlreadyExistsException extends RuntimeException{
    public MovieAlreadyExistsException(String message){
        super(message);
    }
}
