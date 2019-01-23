package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExists;
import com.stackroute.exception.TrackNotFound;
import com.stackroute.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@ControllerAdvice
@RestController
@RequestMapping("api/v1/")
@Api(value = "Track")
public class TrackController {

    TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @ApiOperation(value = "Save Tracks")
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExists {
        ResponseEntity responseEntity;
        trackService.saveTrack(track);
        responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        return responseEntity;
    }

    @ApiOperation(value = "Get All Tracks")
    @GetMapping("tracks")
    public ResponseEntity<?> getAllTrack() {

        return new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get Track By Id")
    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) throws TrackNotFound {

        return new ResponseEntity<Optional<Track>>(trackService.getTrackById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Find Track By Name")
    @GetMapping("tracks/{name}")
    public ResponseEntity<?> findTrackByTrackName(@PathVariable String name) {
        return new ResponseEntity<List<Track>>(trackService.findByTrackName(name), HttpStatus.OK);
    }

    @ApiOperation(value = "Update Comments")
    @PutMapping("updatetrack")
    public ResponseEntity<?> updateComments(@RequestBody Track track) throws TrackNotFound {
        return new ResponseEntity<Track>(trackService.updateComments(track), HttpStatus.OK);
    }
    @ApiOperation(value = "Delete Tracks By Id")
    @DeleteMapping("deletetrack/{id}")
    public ResponseEntity<?> removeTrack(@PathVariable int id) throws TrackNotFound {
        trackService.deleteTrackById(id);
        return new ResponseEntity<String>("removed", HttpStatus.OK);

    }
}
