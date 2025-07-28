package io.codeforall.bootcamp.manager;

import java.io.*;

public class ScoreManager {

    private static final String SCORE_FILE = "highscore.txt";

    public static int loadHighScore() {

        try (BufferedReader reader = new BufferedReader(new FileReader(SCORE_FILE))) {
            return Integer.parseInt(reader.readLine());

        } catch (IOException | NumberFormatException e) {
            return 0;
        }
    }

    public static void saveHighscore(int score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SCORE_FILE))) {
            writer.write(String.valueOf(score));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
