package org.christelle;

import lombok.*;

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
    static int nextId;

    /**
     * adds the course to the student's registeredCourses list, adds the student to the course's registeredStudents list
     * and appends a null for the scores of each assignment of the course
     * @param course the input course
     * @return if the course is already registered or not
     */
    public boolean registerCourse(Course course) {
        //TODO : to be implemented
        return false;
    }

    /**
     * drops a course, remove the course from the student's registeredCourses list, and remove the student from the
     * course's registeredStudents list
     * @param course the imput course
     * @return if the course is not registered yet of not
     */
    public boolean dropCourse(Course course) {
        //TODO : to be implemented
        return false;
    }

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.studentId = "S" + nextId;
        this.registeredCourses = new ArrayList<>();
    }

    public String SimplifiedtoString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", department=" + department.getDepartmentName() +                      // departmentName?
                '}';
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses=" + registeredCourses +
                '}';
    }
}
