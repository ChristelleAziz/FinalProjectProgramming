import org.christelle.*;
import org.christelle.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class MainTest {

    @Test
    public void testIsPostalCodeValid1() {
        String postalCode = "A1B2C3";
        boolean expectedResult = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid2() {
        String postalCode = "A1B 2C3";
        boolean expectedResult = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid3() {
        String postalCode = "A1B2";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid4() {
        String postalCode = "A1B2C34";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid5() {
        String postalCode = "A1B2 C3";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid6() {
        String postalCode = "123456";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid7() {
        String postalCode = "AB1 CD2";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid8() {
        String postalCode = null;
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcAssignmentAvg1() {
        Assignment assignment = new Assignment("Assignment 1", 0.5, 100);
        assignment.setScores(new ArrayList<>());

        assignment.calcAssignmentAvg();

        double expectedResult = 0.0;
        double result = assignment.getAssignmentAverage();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcAssignmentAvg2() {
        Assignment assignment = new Assignment("Assignment 1", 0.5, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(80);
        assignment.setScores(scores);

        assignment.calcAssignmentAvg();

        double expectedResult = 80.0;
        double result = assignment.getAssignmentAverage();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcAssignmentAvg3() {
        Assignment assignment = new Assignment("Assignment 1", 0.5, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(80);
        scores.add(90);
        scores.add(70);
        assignment.setScores(scores);

        assignment.calcAssignmentAvg();

        double expectedResult = 80.0;
        double result = assignment.getAssignmentAverage();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcAssignmentAvg4() {
        Assignment assignment = new Assignment("Assignment 1", 0.5, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(100);
        scores.add(100);
        scores.add(100);
        assignment.setScores(scores);

        assignment.calcAssignmentAvg();

        double expectedResult = 100.0;
        double result = assignment.getAssignmentAverage();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcAssignmentAvg5() {
        Assignment assignment = new Assignment("Assignment 1", 0.5, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(80);
        scores.add(90);
        scores.add(75);
        assignment.setScores(scores);

        assignment.calcAssignmentAvg();

        double expectedResult = 81.666;
        double result = assignment.getAssignmentAverage();

        Assertions.assertEquals(expectedResult, result, 0.001);

    }

    @Test
    public void testCalcAssignmentAvg6() {
        Assignment assignment = new Assignment("Assignment 1", 0.5, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(-80);
        scores.add(-90);
        scores.add(-70);
        assignment.setScores(scores);

        assignment.calcAssignmentAvg();

        double expectedResult = -80.0;
        double result = assignment.getAssignmentAverage();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAssignmentsWeightValid1() {
        Course course = new Course("Mathematics", 3.0, new Department("Math"));
        course.addAssignment("Quiz 1", 0.3, 100);
        course.addAssignment("Midterm", 0.4, 100);
        course.addAssignment("Final", 0.3, 100);

        boolean expectedResult = true;
        boolean result = course.isAssignmentWeightValid();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAssignmentsWeightValid2() {
        Course course = new Course("Mathematics", 3.0, new Department("Math"));
        course.addAssignment("Assignment 1", 0.2, 100);
        course.addAssignment("Assignment 2", 0.3, 100);
        course.addAssignment("Assignment 3", 0.4, 100);

        boolean expectedResult = false;
        boolean result = course.isAssignmentWeightValid();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAssignmentsWeightValid3() {
        Course course = new Course("Mathematics", 3.0, new Department("Math"));
        course.addAssignment("Assignment 1", 0.5, 100);
        course.addAssignment("Assignment 2", 0.6, 100);

        boolean expectedResult = false;
        boolean result = course.isAssignmentWeightValid();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAssignmentsWeightValid4() {
        Course course = new Course("Mathematics", 3.0, new Department("Math"));
        course.addAssignment("Assignment 1", 0.333, 100);
        course.addAssignment("Assignment 2", 0.333, 100);
        course.addAssignment("Assignment 3", 0.334, 100);

        boolean expectedResult = true;
        boolean result = course.isAssignmentWeightValid();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAssignmentsWeightValid5() {
        Course course = new Course("Mathematics", 3.0, new Department("Math"));
        course.addAssignment("Assignment 1", 1.0, 100);

        boolean expectedResult = true;
        boolean result = course.isAssignmentWeightValid();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAssignmentsWeightValid6() {
        Course course = new Course("Mathematics", 3.0, new Department("Math"));
        course.addAssignment("Assignment 1", 0.5, 100);
        course.addAssignment("Assignment 1", -0.5, 100);

        boolean expectedResult = false;
        boolean result = course.isAssignmentWeightValid();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAssignmentsWeightValid7() {
        Course course = new Course("Mathematics", 3.0, new Department("Math"));

        boolean expectedResult = false;
        boolean result = course.isAssignmentWeightValid();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcStudentAvg1() {
        Course course = new Course("Mathematics", 3.0, new Department("Math"));

        int[] expectedResult = new int[0];
        int[] result = course.calcStudentsAverage();

        Assertions.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testCalcStudentAvg2() {
        Course course = new Course("Mathematics", 3.0, new Department("Math"));
        course.addAssignment("Assignment 1", 1.0, 100);
        course.registerStudent(new Student("Alice", Gender.FEMALE, new Address(1, "Street",
                "City", "Province", "PostalCode", "Country"), new Department(
                        "Math")));

        int[] expectedResult = {80};
        int[] result = course.calcStudentsAverage();

        Assertions.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testCalcStudentAvg3() {
        Course course = new Course("Mathematics", 3.0, new Department("Math"));
        course.addAssignment("Assignment 1", 0.3, 100);
        course.addAssignment("Assignment 2", 0.4, 100);
        course.addAssignment("Assignment 3", 0.3, 100);

        course.registerStudent(new Student("Alice", Gender.FEMALE, new Address(1, "Street",
                "City", "Province", "PostalCode", "Country"), new Department(
                        "Math")));
        course.registerStudent(new Student("Bob", Gender.MALE, new Address(2, "Street",
                "City", "Province", "PostalCode", "Country"), new Department(
                        "Math")));
        course.registerStudent(new Student("Charlie", Gender.MALE, new Address(3, "Street",
                "City", "Province", "PostalCode", "Country"), new Department(
                        "Math")));

        int[] expectedResult = {0, 0, 0};
        int[] result = course.calcStudentsAverage();

        Assertions.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testCalcStudentAvg4() {
        Course course = new Course("Mathematics", 3.0, new Department("Math"));
        course.addAssignment("Assignment 1", 0.33, 100);
        course.addAssignment("Assignment 2", 0.33, 100);
        course.addAssignment("Assignment 3", 0.34, 100);

        course.registerStudent(new Student("Alice", Gender.FEMALE, new Address(1, "Street",
                "City", "Province", "PostalCode", "Country"), new Department(
                        "Math")));
        course.registerStudent(new Student("Bob", Gender.MALE, new Address(2, "Street",
                "City", "Province", "PostalCode", "Country"), new Department(
                        "Math")));
        course.registerStudent(new Student("Charlie", Gender.MALE, new Address(3, "Street",
                "City", "Province", "PostalCode", "Country"), new Department(
                        "Math")));

        int[] expectedResult = {80, 80, 85};
        int[] result = course.calcStudentsAverage();

        Assertions.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testCalcStudentAvg5() {
        Course course = new Course("Mathematics", 3.0, new Department("Math"));
        course.addAssignment("Assignment 1", 0, 100);
        course.addAssignment("Assignment 2", 0, 100);
        course.addAssignment("Assignment 3", 0, 100);

        course.registerStudent(new Student("Alice", Gender.FEMALE, new Address(1, "Street",
                "City", "Province", "PostalCode", "Country"), new Department(
                        "Math")));
        course.registerStudent(new Student("Bob", Gender.MALE, new Address(2, "Street",
                "City", "Province", "PostalCode", "Country"), new Department(
                        "Math")));
        course.registerStudent(new Student("Charlie", Gender.MALE, new Address(3, "Street",
                "City", "Province", "PostalCode", "Country"), new Department(
                        "Math")));

        int[] expectedResult = {0, 0, 0};
        int[] result = course.calcStudentsAverage();

        Assertions.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testCalcStudentAvg6() {
        Course course = new Course("Mathematics", 3.0, new Department("Math"));
        course.addAssignment("Assignment 1", 0.333, 100);
        course.addAssignment("Assignment 2", 0.333, 100);
        course.addAssignment("Assignment 3", 0.334, 100);

        course.registerStudent(new Student("Alice", Gender.FEMALE, new Address(1, "Street",
                "City", "Province", "PostalCode", "Country"), new Department(
                        "Math")));
        course.registerStudent(new Student("Bob", Gender.MALE, new Address(2, "Street",
                "City", "Province", "PostalCode", "Country"), new Department(
                        "Math")));

        int[] expectedResult = {80, 80};
        int[] result = course.calcStudentsAverage();

        Assertions.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase1() {
        String strIn = null;
        String expectedResult = null;
        String result = Util.toTitleCase(strIn);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase2() {
        String strIn = "";
        String expectedResult = "";
        String result = Util.toTitleCase(strIn);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase3() {
        String strIn = "  hello world  ";
        String expectedResult = "Hello World";
        String result = Util.toTitleCase(strIn.trim());

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase4() {
        String strIn = "hello world";
        String expectedResult = "Hello World";
        String result = Util.toTitleCase(strIn);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase5() {
        String strIn = "hElLo wOrLd";
        String expectedResult = "Hello World";
        String result = Util.toTitleCase(strIn);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase6() {
        String strIn = "HELLO WORLD";
        String expectedResult = "Hello World";
        String result = Util.toTitleCase(strIn.toLowerCase());

        Assertions.assertEquals(expectedResult, result);
    }
}
