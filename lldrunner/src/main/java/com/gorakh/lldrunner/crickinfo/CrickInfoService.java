package com.gorakh.lldrunner.crickinfo;

import java.util.List;

public class CrickInfoService {
    private static CrickInfoService instance;
    private final MatchService matchService;
    private final ScoreCardService scoreCardService;

    public CrickInfoService() {
        matchService = MatchService.getInstance();
        scoreCardService = ScoreCardService.getInstance();
    }

    public static synchronized CrickInfoService getInstance(){
        if(instance == null){
            instance = new CrickInfoService();
        }
        return instance;
    }

    public void addMatch(Match match) {
        matchService.addMatch(match);
    }

    public Match getMatch(String matchId) {
        return matchService.getMatch(matchId);
    }

    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    public void updateMatchStatus(String matchId, MatchStatus status) {
        matchService.updateMatchStatus(matchId, status);
    }

    public void createScorecard(Match match) {
        scoreCardService.createScorecard(match);
    }

    public void updateScore(String scorecardId, String teamId, int score) {
        scoreCardService.updateScore(scorecardId, teamId, score);
    }

    public void addInnings(String scorecardId, Inning innings) {
        scoreCardService.addInnings(scorecardId, innings);
    }

    public ScoreCard getScorecard(String scorecardId) {
        return scoreCardService.getScorecard(scorecardId);
    }

}
