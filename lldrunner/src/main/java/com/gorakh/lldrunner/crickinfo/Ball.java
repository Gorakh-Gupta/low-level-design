package com.gorakh.lldrunner.crickinfo;

public class Ball {

    private final int ballno;
    private final String bowler;
    private final String batman;
    private final String result;

    public Ball(int ballno, String bowler, String batman, String result) {
        this.ballno = ballno;
        this.bowler = bowler;
        this.batman = batman;
        this.result = result;
    }

    public int getBallno() {
        return ballno;
    }

    public String getBowler() {
        return bowler;
    }

    public String getBatman() {
        return batman;
    }

    public String getResult() {
        return result;
    }
}
