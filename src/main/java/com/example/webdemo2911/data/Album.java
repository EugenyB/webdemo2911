package com.example.webdemo2911.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AlbumId", nullable = false)
    private Integer id;

    @Column(name = "Title", nullable = false, length = 160)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ArtistId", nullable = false)
    private Artist artist;

    public Album(String album, Artist artist) {
        this.title = album;
        this.artist = artist;
    }
}