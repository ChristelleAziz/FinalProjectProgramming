package org.christelle;

import java.util.ArrayList;
import java.util.Random;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAverage;
    private ArrayList<Integer> scores;
    private static int nextId;

    /**
     * calculates the average score for one assignment
     */
    public void calcAssignmentAvg() {
        if (scores.isEmpty()) {
            assignmentAverage = 0;
            return;
        }

        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        assignmentAverage = sum / scores.size();
    }

    /***
     * generates random scores for all students in an assignment
     */
    public void generateRandomScore() {
        if (scores == null) {
            scores = new ArrayList<>();
        }

        Random rand = new Random();

        for (int i = 0; i < scores.size(); i++) {
            int section = rand.nextInt(0, 11);
            int score = switch (section) {
                case 0 -> rand.nextInt(1, 10);
                case 1, 2 -> rand.nextInt(60, 70);
                case 3, 4 -> rand.nextInt(70, 80);
                case 5, 6, 7, 8 -> rand.nextInt(80, 90);
                case 9, 10 -> rand.nextInt(90, 101);
                default -> -1;
            };

            scores.add(score);
        }
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                ", maxScore=" + maxScore +
                '}';
    }
}
