package com.gorakh.lldrunner.crickinfo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreCard {
    private final String id;
    private final Match match;
    private final Map<String, Integer> teamScores;
    private final List<Inning> innings;

    public ScoreCard(String id, Match match) {
        this.id = id;
        this.match = match;
        this.teamScores = new HashMap<>();
        this.innings = new ArrayList<>();
    }


    public void updateScore(String teamId, int score) {
        teamScores.put(teamId, score);
    }

    public void addInnings(Inning innings) {
        this.innings.add(innings);
    }
    public String getId() {
        return id;
    }

    public Match getMatch() {
        return match;
    }

    public Map<String, Integer> getTeamScores() {
        return teamScores;
    }

    public List<Inning> getInnings() {
        return innings;
    }
}
