package com.press.article.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Long id){
        super("Resource not found under id: " + id);
    }
}
