package com.stackroute.config;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListener implements org.springframework.context.ApplicationListener<ContextRefreshedEvent> {

    TrackService trackService;

    @Autowired
    public ApplicationListener(TrackService trackService) {
        this.trackService = trackService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Track track = new Track();
        track.setTrackId(0);
        track.setTrackName("default");
        track.setComments("default comments");
        try {
            trackService.saveTrack(track);
        }
        catch (Exception e){}
    }

}
