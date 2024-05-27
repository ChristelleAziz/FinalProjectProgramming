package org.christelle;

import lombok.*;
import org.christelle.util.Util;
import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private ArrayList<Double> finalScores;
    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseId = "C-" + department.getDepartmentId() + "-" + String.format("%02d", nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.finalScores = new ArrayList<>();
    }

    /**
     * checks if the sum of weights of all assignments of a course equals to 1 (100%)
     * @return if the sum is valid or not
     */
    public boolean isAssignmentWeightValid() {
        if (assignments.isEmpty()) {
            return false;
        }

        double sum = 0;
        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }

        double tolerance = 0.001;
        return Math.abs(sum - 1.0) < tolerance;
    }

    /**
     * adds a student to the student list of the course, adds a new null element to each assignment of this course,
     * and adds  a new null element for the finalScores.
     * @param student the input student
     * @return if the student is successfully registered or not
     */
    public boolean registerStudent(Student student) {
        if (!registeredStudents.contains(student)) {
            registeredStudents.add(student);
            for (Assignment assignment : assignments) {
                assignment.add(null);
            }
            finalScores.add(null);
            return true;
        }

        return false;
    }

    /**
     * calculates the weighted average score of a student
     * @return the array with the averages
     */
    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double sum = 0;
            double totalWeight = 0;

            for (Assignment assignment : assignments) {
                ArrayList<Integer> scores = assignment.getScores();
                if (scores != null && scores.size() > i && scores.get(i) != null) {
                    sum += scores.get(i) * assignment.getWeight();
                    totalWeight += assignment.getWeight();
                }
            }

            if (totalWeight != 0) {
                averages[i] = (int) (sum / totalWeight);
            }
        }

        return averages;
    }

    /**
     * adds a new assignment to the course
     * @param assignmentName the input assignment name
     * @param weight the input assignment weight
     * @param maxScore the input assignment maxScore
     * @return if the assignment was successfully added to the course or not
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment assignment = new Assignment(assignmentName, weight, maxScore);
        assignment.setScores(new ArrayList<>()); // Initialize scores list
        if (assignments.contains(assignment)) {
            return false;
        }
        assignments.add(assignment);
        return true;
    }

    /**
     * generates random scores for each assignment and student, and calculates the final score for each student.
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
            assignment.calcAssignmentAvg();
        }
        for (int i = 0; i < registeredStudents.size(); i++) {
            double totalScore = 0;
            for (Assignment assignment : assignments) {
                totalScore += assignment.getScores().get(i) * assignment.getWeight();
            }
            finalScores.set(i, totalScore);
        }
    }

    /**
     * Displays the scores of a course in a table, with the assignment averages and student weighted average
     */
    public void displayScores() {
        System.out.printf("Course: %s(%s)%n", courseName, courseId);
        System.out.printf("%-20s", "");
        for (Assignment assignment : assignments) {
            System.out.printf("%-15s", assignment.getAssignmentName());
        }
        System.out.println("Final Score");

        for (Student student : registeredStudents) {
            System.out.printf("%-20s", student.getStudentName());
            for (Assignment assignment : assignments) {
                System.out.printf("%-15d", assignment.getScores().get(registeredStudents.indexOf(student)));
            }
            System.out.printf("%-15.2f%n", finalScores.get(registeredStudents.indexOf(student)));
        }

        System.out.printf("%-20s", "Average");
        for (Assignment assignment : assignments) {
            System.out.printf("%-15.2f", assignment.getAssignmentAverage());
        }
        System.out.println();
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
        String studentInfo = "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", departmentName=" + department.getDepartmentName() +
                ", assignments=" + assignments +
                ", registeredStudents=[";

        for (Student student : registeredStudents) {
            studentInfo += student.SimplifiedtoString();
            studentInfo += ", ";
        }

        studentInfo += "]}";
        return studentInfo;
    }
}
