package com.press.article.exceptions;

public class PressArticleNotFoundException extends RuntimeException {

    public PressArticleNotFoundException(Long id){
        super(String.format("Resource under id %d not found.", id));
    }
}
