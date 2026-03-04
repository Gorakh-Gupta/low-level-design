package com.gorakh.lldrunner.crickinfo;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String id;
    private final String name;
    private List<Player> player;

    public Team(String id, String name , List<Player>team) {
        this.id = id;
        this.name = name;
        this.player = team;
    }
}
