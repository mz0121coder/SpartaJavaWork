package com.sparta.mz.advancedjunit;

public class Bowling {

    public static int getScore(String game) {
        String[] scores = game.split(" ");
        int total = 0;
        int games = 0;
        for (String score : scores) {
            if (score.equals("X")) {
                if (games < 10) total += 30;
            } else {
                String roll = score.replaceAll("[^0-9]", "");
                total += Integer.parseInt(roll);
            }
            games++;
        }
        return total;
    }
}
