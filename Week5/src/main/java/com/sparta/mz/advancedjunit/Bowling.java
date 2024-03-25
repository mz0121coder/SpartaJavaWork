package com.sparta.mz.advancedjunit;

public class Bowling {

    public static int getTotalScore(String game) {
        String[] frames = game.split(" ");
        int score = 0;
        int bonus = 0;
        int total = 0;
        for (int i = 0; i < 10; i++) {
            score += getFrameScore(frames[i]);
            bonus = getFrameBonus(frames, i, bonus);
        }
        total += score;
        total += bonus;
        return total;
    }

    private static int getFrameScore(String frame) {
        int frameScore = 0;
        for (int i = 0; i < frame.length(); i++) {
            char roll = frame.charAt(i);
            if (Character.isDigit(roll)) {
                frameScore += Character.getNumericValue(roll);
            }
            ;
            if (roll == '/') {
                frameScore += (10 - frameScore);
            }
            ;
            if (roll == 'X') {
                frameScore += 10;
            }
            ;
        }
        return frameScore;
    }

    private static int getFrameBonus(String[] frames, int i, int bonus) {
        if (isAStrike(frames[i])) {
            bonus = getStrikeBonus(frames, i, bonus);
        }
        if (isASpare(frames[i])) {
            bonus += getSpareBonus(frames, i);
        }
        ;
        return bonus;
    }

    private static int getSpareBonus(String[] frames, int i) {
        return getFrameScore(frames[i + 1].substring(0, 1));
    }

    private static boolean isASpare(String frames) {
        return frames.endsWith("/");
    }

    private static int getStrikeBonus(String[] frames, int i, int bonus) {
        if (isAStrike(frames[i + 1])) {
            bonus += getFrameScore(frames[i + 1]);
            bonus += getFrameScore(frames[i + 2].substring(0, 1));
        } else {
            bonus += getFrameScore(frames[i + 1].substring(0, Math.max(1, frames[i + 1].length())));
        }
        return bonus;
    }

    private static boolean isAStrike(String frames) {
        return frames.equals("X");
    }
}
