package com.example.webdemo2911.repositories;

import com.example.webdemo2911.data.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}