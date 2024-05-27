# FinalProjectProgramming

This is the repo for the final project in programming.

## Classes and Methods

### Address
- Fields: streetNo, street, city, province, postalCode, country
- Methods: isPostalCodeValid, Constructor, toString, equals, getters, setters

### Department
- Fields: departmentId, departmentName, nextId
- Methods: validateDepartmentName, Constructor, toString, equals, getters, setters

### Student
- Fields: studentId, studentName, gender, address, department, registeredCourses, nextId
- Methods: registerCourse, dropCourse, Constructor, toSimplifiedString, toString, equals, getters, setters

### Assignment
- Fields: assignmentId, assignmentName, weight, maxScore, assignmentAverage, scores, nextId
- Methods: calcAssignmentAvg, generateRandomScore, toString, getters, setters

### Course
- Fields: courseId, courseName, credits, department, assignments, registeredStudents, finalScores, nextId
- Methods: isAssignmentWeightValid, registerStudent, calcStudentsAverage, addAssignment, generateScores, displayScores, toString, getters, setters

### Gender
- Enum: FEMALE, MALE

### Util
- Methods: toTitleCase

## Unit Testing

The following methods have unit tests:

- Address: isPostalCodeValid
- Assignment: calcAssignmentAvg, isAssignmentsWeightValid
- Course: calcStudentsAverage
- Util: toTitleCase
