package com.stackroute.exception;

import lombok.Data;

@Data
public class ErrorClass {

    private String errormessage;

    private String requestedURI;
}

