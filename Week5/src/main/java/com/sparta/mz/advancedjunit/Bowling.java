package com.sparta.mz.advancedjunit;

public class Bowling {

    public static int getTotalScore(String game) {
        String[] frames = game.split(" ");
        int score = 0;
        int bonus = 0;
        int total = 0;
        for (int i = 0; i < 10; i++) {
            score += getFrameScore(frames[i]);
        }
        return total;
    }

    private static int getFrameScore(String frame) {
        int frameScore = 0;
        for (int i = 0; i < frame.length(); i++) {
            char roll = frame.charAt(i);
            if (Character.isDigit(roll)) frameScore += Integer.parseInt(String.valueOf(roll));
            if (roll == '/') frameScore += (10 - frameScore);
            if (roll == 'X') frameScore += 10;
        }
        return frameScore;
    }
}
