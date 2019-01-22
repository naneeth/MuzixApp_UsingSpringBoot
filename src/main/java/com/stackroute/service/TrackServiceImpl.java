package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {


    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
       Track savedTrack = trackRepository.save(track);
       return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() {

        return trackRepository.findAll();
    }

    @Override
    public Optional<Track> getTrackById(int id) {

        Optional<Track> getTrack = trackRepository.findById(id);
        return  getTrack;
    }

    @Override
    public Track updateComments(Track track) {
        trackRepository.delete(track);
      Track updatedTrack  =saveTrack(track);
     return updatedTrack;

    }

    @Override
    public  void deleteTrackById(int id) {

         trackRepository.deleteById(id);
    }

    @Override
    public List<Track> findByTrackName(String trackName) {
        return trackRepository.findByTrackName(trackName);
    }

}
