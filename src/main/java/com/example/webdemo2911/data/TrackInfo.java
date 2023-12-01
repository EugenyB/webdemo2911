package com.example.webdemo2911.data;

import org.springframework.beans.factory.annotation.Value;

/**
 * Projection for {@link Track}
 */
public interface TrackInfo {
    Integer getId();

    @Value("#{target.composer!=null ? target.name + ' by ' + target.composer : target.name }")
    String getFullTitle();

    Integer getMilliseconds();
}