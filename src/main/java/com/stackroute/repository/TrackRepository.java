package com.stackroute.repository;


import com.stackroute.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * This is Track object repository interface to implement the track service in repository.
 */
@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {

    @Query("select p from Track p where p.trackName = ?1")
    List<Track> findByTrackName(String trackName);
}