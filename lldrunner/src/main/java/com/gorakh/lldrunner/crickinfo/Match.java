package com.gorakh.lldrunner.crickinfo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Match {
    private final String id;
    private final String title;
    private final String venue;
    private final LocalDateTime start_time;
    private List<Team>team;
    private MatchStatus matchStatus;
    private List<ScoreCard>scoreCard;

    public Match(String id, String title, String venue, LocalDateTime start_time, List<Team>teams) {
        this.id = id;
        this.title = title;
        this.venue = venue;
        this.start_time = start_time;
        this.matchStatus = MatchStatus.SHCEDULED;
        this.team = teams;
        scoreCard = new ArrayList<>();

    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getVenue() {
        return venue;
    }

    public List<Team> getTeam() {
        return team;
    }

    public MatchStatus getMatchStatus() {
        return matchStatus;
    }

    public List<ScoreCard> getScoreCard() {
        return scoreCard;
    }

    public void setStatus(MatchStatus matchStatus) {
        this.matchStatus = matchStatus;
    }
}
