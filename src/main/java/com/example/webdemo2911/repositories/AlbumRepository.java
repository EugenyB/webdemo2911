package com.example.webdemo2911.repositories;

import com.example.webdemo2911.data.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}