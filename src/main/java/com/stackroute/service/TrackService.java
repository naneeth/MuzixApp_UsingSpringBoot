package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExists;
import com.stackroute.exception.TrackNotFound;

import java.util.List;
import java.util.Optional;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExists;

    public List<Track> getAllTracks();

    public Optional<Track> getTrackById(int id) throws TrackNotFound;

    public Track updateComments(Track track) throws TrackNotFound;

    public void deleteTrackById(int id) throws TrackNotFound;

    List<Track> findByTrackName(String trackName);
}
