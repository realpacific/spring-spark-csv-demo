package com.realpacific.springsparkcsvdemo.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}
