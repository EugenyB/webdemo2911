package com.example.webdemo2911.services;

import com.example.webdemo2911.data.Playlist;
import com.example.webdemo2911.data.Track;
import com.example.webdemo2911.data.TrackInfo;
import com.example.webdemo2911.repositories.PlaylistRepository;
import com.example.webdemo2911.repositories.TrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final TrackService trackService;

    public List<Playlist> getPlaylists() {
        return playlistRepository.findAll();
    }

    public Optional<Playlist> getPlaylist(int id) {
        return playlistRepository.findById(id);
    }

    public List<TrackInfo> getTracksAvailable(int id) {
        return trackService.findTracksAvailableForPlaylist(id);
    }

    public void addTrackToPlaylist(int playlistId, int trackId) {
        Track track = trackService.find(trackId);
        Playlist playlist = getPlaylist(playlistId).get();
        playlist.getTracks().add(track);
        playlistRepository.save(playlist);
    }

    public void deleteTrackFromPlaylist(int pid, int tid) {
        Playlist playlist = getPlaylist(pid).get();
        playlist.getTracks().removeIf(t->t.getId() == tid);
        playlistRepository.save(playlist);
    }
}
