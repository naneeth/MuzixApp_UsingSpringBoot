package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class TrackController {

    TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?>saveTrack(@RequestBody Track track){
        ResponseEntity responseEntity;
        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        }
        catch (Exception ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @GetMapping("tracks")
    public ResponseEntity<?>getAllTrack(){
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }

    @GetMapping("track/{id}")
    public ResponseEntity<?>getTrackById(@PathVariable int id){
        return new ResponseEntity<Optional<Track>>(trackService.getTrackById(id),HttpStatus.OK);
    }


    @PutMapping("updatetrack")
    public ResponseEntity<?>updateComments(@RequestBody Track track){
        return new ResponseEntity<Track>(trackService.updateComments(track),HttpStatus.OK);
    }

    @DeleteMapping("deletetrack/{id}")
        public ResponseEntity<?>removeTrack(@PathVariable int id){
        trackService.deleteTrackById(id);
        return new ResponseEntity<String>("removed",HttpStatus.OK);
    }


    }
