package labyrinth.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class HighScoreManager {

    private Timer timer;
    private long startTime;
    private long elapsedTime;
    private boolean isRunning;

    private Map<String, Long> highScores;

    public HighScoreManager() {
        this.timer = new Timer();
        this.highScores = new HashMap<>();
        this.isRunning = false;
        this.elapsedTime = 0;
    }


    public void startTimer() {
        if (isRunning) {
            System.out.println("Timer is already running!");
            return;
        }

        startTime = System.currentTimeMillis();
        isRunning = true;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (isRunning) {
                    elapsedTime = System.currentTimeMillis() - startTime;
                }
            }
        }, 0, 1000);
    }


    public void stopTimer() {
        if (!isRunning) {
            System.out.println("Timer is not running!");
            return;
        }

        isRunning = false;
        timer.cancel();
        timer = new Timer();
        elapsedTime = System.currentTimeMillis() - startTime;
    }


    public void resetTimer() {
        stopTimer();
        elapsedTime = 0;
    }


    public long getElapsedTimeInSeconds() {
        return elapsedTime / 1000;
    }


    public void addHighScore(String playerName, long score) {
        highScores.put(playerName, score);
    }


    public Map<String, Long> getHighScores() {
        return highScores;
    }


    public void displayHighScores() {
        System.out.println("High Scores:");
        highScores.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " seconds"));
    }
}