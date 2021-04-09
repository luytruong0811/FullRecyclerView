package com.example.fullrecyclerview;

import java.io.Serializable;

public class Song implements Serializable {
    private String mCode;
    private String mTitle;
    private String mLyric;
    private String mArtist;

    public Song(String code, String title, String lyric, String artist) {
        this.mCode = code;
        this.mTitle = title;
        this.mLyric = lyric;
        this.mArtist = artist;
    }

    public String getCode() {
        return mCode;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getLyric() {
        return mLyric;
    }

    public String getArtist() {
        return mArtist;
    }




}
