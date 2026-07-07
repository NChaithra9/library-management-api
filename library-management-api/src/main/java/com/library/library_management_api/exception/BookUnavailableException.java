package com.library.library_management_api.exception;

public class BookUnavailableException extends RuntimeException {

    public BookUnavailableException(String message) {
        super(message);
    }

}