package com.example.exception;

/**
 * Created by benny on 21.10.15.
 */
public class ItemFoundException extends RuntimeException {

    private static final long serialVersionUID = -3845574518872003019L;

    public ItemFoundException() {
        super();
    }

    public ItemFoundException(String message) {
        super(message);
    }
}
