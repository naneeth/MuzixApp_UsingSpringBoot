package com.stackroute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException {

//    @ExceptionHandler(TrackAlreadyExists.class) public ResponseEntity< ? > TrackExistsException(final TrackAlreadyExists e) {
//        return error(e, HttpStatus.CONFLICT, e.getMessage());
//    }
//    @ExceptionHandler(TrackNotFound.class) public ResponseEntity< ? > NoTrackException(final TrackNotFound e) {
//        return error(e, HttpStatus.CONFLICT, e.getMessage());
//    }


    @ExceptionHandler(TrackNotFound.class)
    public ResponseEntity<?> noTrack(final Exception ex){
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TrackAlreadyExists.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ResponseEntity<?> trackExists(final Exception ex){
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
    }

}