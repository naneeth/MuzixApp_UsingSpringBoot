package com.stackroute.exception;

public class TrackNotFound extends Exception {
    private String messsage;

    public TrackNotFound() {
    }

    public TrackNotFound(String message) {
        super(message);
        this.messsage = messsage;
    }
}
