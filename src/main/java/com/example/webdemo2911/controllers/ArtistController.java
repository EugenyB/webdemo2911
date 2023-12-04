package com.example.webdemo2911.controllers;

import com.example.webdemo2911.data.Artist;
import com.example.webdemo2911.services.AlbumService;
import com.example.webdemo2911.services.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class ArtistController {

    private final ArtistService artistService;

    private AlbumService albumService;

    @GetMapping("/artists")
    public String showArtists(Model model) {
        model.addAttribute("artists", artistService.getArtists());
        return "artists";
    }

    @GetMapping("/artist_info/{id}")
    public String artistInfo(@PathVariable int id, Model model) {
        Optional<Artist> artist = artistService.getArtist(id);
        if (artist.isPresent()) {
            model.addAttribute("artist", artist.get());
            return "artist_info";
        } else {
            return "artist_not_found";
        }
    }

    @PostMapping("/artist_info/add_album")
    public String addAlbum(@RequestParam int aid, @RequestParam String album) {
        Optional<Artist> artist = artistService.getArtist(aid);
        if (artist.isPresent()) {
            albumService.addAlbum(artist.get(), album);
            return "redirect:/artist_info/" + aid;
        }
        return null;
    }
}
