package com.google.apigee.demo;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String resource) {
        super("Not found: " + resource);
    }
}
