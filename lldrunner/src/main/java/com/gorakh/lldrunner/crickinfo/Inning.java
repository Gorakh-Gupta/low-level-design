package com.gorakh.lldrunner.crickinfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inning {
    private final String id;
    private final String battingTeamId;
    private final String bowlingTeamId;
    private final List<Over> overs;

    public Inning(String id, String battingTeamId, String bowlingTeamId) {
        this.id = id;
        this.battingTeamId = battingTeamId;
        this.bowlingTeamId = bowlingTeamId;
        this.overs = new ArrayList<>();
    }

    public void addOver(Over over1) {
    }

    public String getId() {
        return id;
    }

    public String getBattingTeamId() {
        return battingTeamId;
    }

    public String getBowlingTeamId() {
        return bowlingTeamId;
    }

    public List<Over> getOvers() {
        return overs;
    }
}
