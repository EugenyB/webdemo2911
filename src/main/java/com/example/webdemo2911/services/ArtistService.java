package com.example.webdemo2911.services;

import com.example.webdemo2911.data.Artist;
import com.example.webdemo2911.repositories.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;

    public List<Artist> getArtists() {
        return artistRepository.findAll();
    }

    public Optional<Artist> getArtist(Integer id) {
        return artistRepository.findById(id);
    }
}
