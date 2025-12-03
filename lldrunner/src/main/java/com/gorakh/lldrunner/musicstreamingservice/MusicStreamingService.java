package com.gorakh.lldrunner.musicstreamingservice;

import java.util.concurrent.SynchronousQueue;

public class MusicStreamingService {

//    private static MusicStreamingService instance;
    private final MusicLibrary musicLibrary;
    private final UserManager userManager;
    private final MusicRecommender musicRecommender;
    public MusicStreamingService() {
        musicLibrary = MusicLibrary.getInstance();
        userManager = UserManager.getInstance();
        musicRecommender = MusicRecommender.getInstance();
    }

//
//    public static synchronized MusicStreamingService getInstance(){
//        if(instance == null){
//            instance = new MusicStreamingService();
//        }
//        return instance;
//    }

    public void start() {

    }

    public MusicLibrary getMusicLibrary() {
//        System.out.println("OOOOOOOOOOO");
        return musicLibrary;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public MusicRecommender getMusicRecommender() {
        return musicRecommender;
    }
}
