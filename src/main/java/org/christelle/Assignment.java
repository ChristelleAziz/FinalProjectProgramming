package org.christelle;

import java.util.ArrayList;

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
        //TODO: to be implemented
    }

    /***
     * generates random scores for all students in an assignment
     */
    public void generateRandomScore() {
        //TODO: to be implemented
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
