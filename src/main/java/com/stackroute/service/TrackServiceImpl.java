package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExists;
import com.stackroute.exception.TrackNotFound;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {


   private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExists {
        if (trackRepository.existsById(track.getTrackId())) {
            throw new TrackAlreadyExists("TrackAlreadyExists");
        } else {
            Track savedTrack = trackRepository.save(track);
            return savedTrack;
        }
    }

    @Override
    public List<Track> getAllTracks() {

        return trackRepository.findAll();
    }

    @Override
    public Optional<Track> getTrackById(int id) throws TrackNotFound {
        if (trackRepository.existsById(id)) {
            Optional<Track> getTrack = trackRepository.findById(id);
            return getTrack;
        } else {
            throw new TrackNotFound("Track Not Found");
        }
    }

    @Override
    public Track updateComments(Track track) throws TrackNotFound {
        if (!trackRepository.existsById(track.getTrackId())) {
            throw new TrackNotFound("TrackNotFound");
        } else {
            Track savedTrack = trackRepository.save(track);
            return savedTrack;
        }


    }

    @Override
    public void deleteTrackById(int id) throws TrackNotFound {
        if (trackRepository.existsById(id)) {
            trackRepository.deleteById(id);
        } else {
            throw new TrackNotFound("Track Not Found");
        }
    }

    @Override
    public List<Track> findByTrackName(String trackName) {
        return trackRepository.findByTrackName(trackName);
    }


}
