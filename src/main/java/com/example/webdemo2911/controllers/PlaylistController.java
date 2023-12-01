package com.example.webdemo2911.controllers;

import com.example.webdemo2911.data.Artist;
import com.example.webdemo2911.data.Playlist;
import com.example.webdemo2911.data.Track;
import com.example.webdemo2911.data.TrackInfo;
import com.example.webdemo2911.services.PlaylistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;

    @GetMapping("/playlists")
    public String playlists(Model model) {
        model.addAttribute("playlists", playlistService.getPlaylists());
        return "playlists";
    }

    @GetMapping("/playlist_info/{id}")
    public String tracksByPlaylist(@PathVariable int id, Model model) {
        Optional<Playlist> playlistOpt = playlistService.getPlaylist(id);
        if (playlistOpt.isPresent()) {
            model.addAttribute("pl", playlistOpt.get());
            List<TrackInfo> tracksAvailable = playlistService.getTracksAvailable(id);
            model.addAttribute("ta", tracksAvailable);
            return "playlist_info";
        } else {
            return "playlist_not_found";
        }
    }

    @PostMapping("/add_track")
    public String addTrackToPlaylist(@RequestParam int playlist, @RequestParam int track) {
        playlistService.addTrackToPlaylist(playlist, track);

        return "redirect:/playlist_info/"+playlist;
    }

    @GetMapping("/delete_track/{pid}/{tid}")
    public String deleteTrackFromPlaylist(@PathVariable int pid, @PathVariable int tid){
        playlistService.deleteTrackFromPlaylist(pid, tid);

        return "redirect:/playlist_info/"+pid;
    }
}
