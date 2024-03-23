package com.sparta.mz.advancedjunit;

public class Bowling {

    public static int getTotalScore(String game) {
        String[] frames = game.split(" ");
        int score = 0;
        int bonus = 0;
        int total = 0;
        for (int i = 0; i < 10; i++) {
            score += getFrameScore(frames[i]);
            if (frames[i].equals("X")) {
                if (frames[i + 1].equals("X")) {
                    bonus += getFrameScore(frames[i + 1]);
                    bonus += getFrameScore(frames[i + 2].substring(0, 1));
                } else {
                    bonus += getFrameScore(frames[i + 1].substring(0, 2));
                }
            }
            if (frames[i].endsWith("/")) bonus += getFrameScore(frames[i + 1].substring(0, 1));
        }
        total += score + bonus;
        return total;
    }

    private static int getFrameScore(String frame) {
        int frameScore = 0;
        for (int i = 0; i < frame.length(); i++) {
            char roll = frame.charAt(i);
            if (Character.isDigit(roll)) frameScore += Character.getNumericValue(roll);
            if (roll == '/') frameScore += (10 - frameScore);
            if (roll == 'X') frameScore += 10;
        }
        return frameScore;
    }
}
