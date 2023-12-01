package com.example.webdemo2911.repositories;

import com.example.webdemo2911.data.Track;
import com.example.webdemo2911.data.TrackInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Integer> {
    List<TrackInfo> findByComposerNotNull();

}