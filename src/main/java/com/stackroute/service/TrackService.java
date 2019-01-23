package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExists;
import com.stackroute.exception.TrackNotFound;

import java.util.List;
import java.util.Optional;

/*
 * This is an interface to implement the Track class of domain package.
 */
public interface TrackService {
    /*
     * This method provide user a mean to add new track in the database.
     */
    public Track saveTrack(Track track) throws TrackAlreadyExists;

    /*
     * This method provide user with all the track in the database.
     */

    public List<Track> getAllTracks();

    /*
     *This method provide track details to the user of particular track Id.
     */
    public Optional<Track> getTrackById(int id) throws TrackNotFound;

    /*
     * This method help user to update track comment of a particular track Id.
     */
    public Track updateComments(Track track) throws TrackNotFound;

    /*
     * This method help user to remove the track from database based on the input track Id.
     */
    public void deleteTrackById(int id) throws TrackNotFound;

    List<Track> findByTrackName(String trackName);
}
