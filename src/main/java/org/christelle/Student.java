package org.christelle;

import lombok.*;
import org.christelle.util.Util;
import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    static int nextId = 1;

    /**
     * adds the course to the student's registeredCourses list, adds the student to the course's registeredStudents list
     * and appends a null for the scores of each assignment of the course
     * @param course the input course
     * @return if the course is successfully registered or not
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.add(course);
        course.getRegisteredStudents().add(this);
        for (Assignment assignment : course.getAssignments()) {
            assignment.getScores().add(null);
        }

        return true;
    }

    /**
     * remove the course from the student's registeredCourses list, and remove the student from the
     * course's registeredStudents list
     * @param course the input course
     * @return if the course is successfully dropped or not
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);

        return true;
    }

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = "S" + String.format("%05d", nextId++);
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    public String SimplifiedtoString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", department=" + department.getDepartmentName() +
                '}';
    }

    @Override
    public String toString() {
        String studentInfo = "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses=[";

        for (int i = 0; i < registeredCourses.size(); i++) {
            Course course = registeredCourses.get(i);
            studentInfo += "\n\tCourse{" +
                    "courseId='" + course.getCourseId() + '\'' +
                    ", courseName='" + course.getCourseName() + '\'' +
                    ", departmentName=" + course.getDepartment().getDepartmentName() +
                    '}';
            if (i < registeredCourses.size() - 1) {
                studentInfo += ", ";
            }
        }

        studentInfo += "\n]}";
        return studentInfo;
    }
}
