package com.example.webdemo2911.repositories;

import com.example.webdemo2911.data.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}