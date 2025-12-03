package com.gorakh.lldrunner.musicstreamingservice;

import java.util.ArrayList;
import java.util.List;

public class PlayList {

    private final String id;
    private final String name;
    private final User owner;
    private final List<Song> songs;

    public PlayList(String id, String name, User owner) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.songs = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }
}
