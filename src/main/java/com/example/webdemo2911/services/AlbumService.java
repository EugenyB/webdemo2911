package com.example.webdemo2911.services;

import com.example.webdemo2911.data.Album;
import com.example.webdemo2911.data.Artist;
import com.example.webdemo2911.repositories.AlbumRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;


    public void addAlbum(Artist artist, String album) {
        albumRepository.save(new Album(album, artist));
    }
}
