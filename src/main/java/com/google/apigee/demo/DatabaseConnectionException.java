package com.google.apigee.demo;

public class DatabaseConnectionException extends Exception {
    public DatabaseConnectionException() {
        super("Error connecting to MySQL database `resources` on 10.4.2.10:3609 : connection timeout");
    }
}
