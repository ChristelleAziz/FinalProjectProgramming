package org.christelle;

import lombok.*;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;        // contructor
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private ArrayList<Double> finalScores;
    static int nextId;

    /**
     * checks if the sum of weights of all assignments of that course equals to 1 (100%)
     * @return
     */
    public static boolean isAssignmentWeightValid() {
        //TODO : to be implemented
        return false;
    }

    /**
     * adds a student to the student list of the course, also add a new null element to each assignment of this course,
     * and add a new null element for the finalScores.
     * @param student
     * @return
     */
    public static boolean registerStudent(Student student) {
        //TODO : to be implemented
        return false;
    }

    /**
     * calculates the weighted average score of a student
     * @return
     */
    public static int[] calcStudentsAverage() {
        //TODO : to be implemented
        int[] weightedAverageScore = new int[0];
        return weightedAverageScore;
    }

    /**
     * adds a new assignment to the course
     * @param assignmentName the input assignment name
     * @param weight the input weight
     * @param maxScore the input max score
     * @return an array with the weighted average score
     */
    public static boolean addAssignment(String assignmentName, double weight, int maxScore) {
        //TODO : to be implemented

        int[] weightedAverageScore = new int[0];
        return weightedAverageScore;
    }

    /**
     * Displays the scores of a course in a table, with the assignment averages and student weighted average
     */
    public void generateScores() {
        //TODO: to be implemented
    }

    public String SimplifiedtoString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", departmentName=" + department.getDepartmentName() +
                '}';
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", departmentName=" + department.getDepartmentName() +
                ", assignments=" + assignments +
                ", registeredStudents=" + registeredStudents +
                '}';
    }
}
