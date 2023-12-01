package com.example.webdemo2911.repositories;

import com.example.webdemo2911.data.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

}