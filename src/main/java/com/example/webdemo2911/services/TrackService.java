package com.example.webdemo2911.services;

import com.example.webdemo2911.data.Playlist;
import com.example.webdemo2911.data.Track;
import com.example.webdemo2911.repositories.TrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrackService {

    private final TrackRepository trackRepository;

    public List<Track> findTracksAvailableForPlaylist(Playlist playlist) {
        List<Track> all = trackRepository.findAll();
        return all.stream().filter(t -> !t.getPlaylists().contains(playlist)).toList();
    }

    public Track find(int trackId) {
        return trackRepository.findById(trackId).get();
    }
}
