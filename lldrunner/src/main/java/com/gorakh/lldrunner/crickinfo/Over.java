package com.gorakh.lldrunner.crickinfo;

import java.util.ArrayList;
import java.util.List;

public class Over {
    private final int overno;
    private List<Ball>balls;

    public Over(int overno) {
        this.overno = overno;
        balls = new ArrayList<>();
    }

    public void addBall(Ball ball) {
    }

    public int getOverno() {
        return overno;
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
