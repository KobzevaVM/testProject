package com.game.controller;

public class PlayerInfo {
    private String name;
    private int countGames;
    private int countWins;
    String ip;

    private int goodAnswer;

    public PlayerInfo(String name, String ip) {
        this.name = name;
        this.countGames = 0;
        this.countWins = 0;
        this.goodAnswer = 0;
        this.ip = ip;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountGames() {
        return this.countGames;
    }

    public void setCountGames(int count) {
        this.countGames = count;
    }

    public int getCountWins() {
        return this.countWins;
    }

    public void setCountWins(int count) {
        this.countWins = count;
    }

    public int getGoodAnswer() {
        return this.goodAnswer;
    }

    public void setGoodAnswer(int goodAnswer) {
        this.goodAnswer = goodAnswer;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
