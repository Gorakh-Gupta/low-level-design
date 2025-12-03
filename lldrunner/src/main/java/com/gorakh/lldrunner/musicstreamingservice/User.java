package com.gorakh.lldrunner.musicstreamingservice;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String id;
    private final String username;
    private final String password;

    private final List<PlayList> playlists;


    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        playlists = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public void addPlaylist(PlayList playlist) {
        playlists.add(playlist);
    }

    public List<PlayList> getPlaylists() {
        return playlists;
    }
}
