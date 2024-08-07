package com.pratikesh.prod_ready_features.prodReadyFeatures.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
