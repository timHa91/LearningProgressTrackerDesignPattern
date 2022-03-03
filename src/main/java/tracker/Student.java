package tracker;

import tracker.course.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private List<Course> courseList;


    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.courseList = new ArrayList<>();
        initCourses();
    }

    public void addLearningProgress(String javaPoints, String dsaPoints, String dataBasePoints, String springPoints) {
        // Java
        if(courseList.size() >= 4) {
            Course java = courseList.get(0);
            int javaPointsNumber = Integer.parseInt(javaPoints);
            if (javaPointsNumber > 0 && !java.isEnrolled) {
                java.isEnrolled = true;
                // Update Course Info
                DataStore.courses.get(0).increaseCount().addPoints(javaPointsNumber);

            }
            DataStore.courses.get(0).addPoints(javaPointsNumber);
            java.addCurrentPoints(javaPointsNumber);
            // DSA
            Course dsa = courseList.get(1);
            int dsaPointsNumber = Integer.parseInt(dsaPoints);
            if (dsaPointsNumber > 0 && !dsa.isEnrolled) {
                java.isEnrolled = true;
                // Update Course Info
                DataStore.courses.get(1).increaseCount().addPoints(dsaPointsNumber);
            }
            DataStore.courses.get(1).addPoints(dsaPointsNumber);
            dsa.addCurrentPoints(dsaPointsNumber);
            // Database
            Course database = courseList.get(2);
            int databasePointsNumber = Integer.parseInt(dataBasePoints);
            if (databasePointsNumber > 0 && !database.isEnrolled) {
                java.isEnrolled = true;
                // Update Course Info
                DataStore.courses.get(2).increaseCount().addPoints(databasePointsNumber);
            }
            DataStore.courses.get(2).addPoints(databasePointsNumber);
            database.addCurrentPoints(databasePointsNumber);
            // Spring
            Course spring = courseList.get(3);
            int springPointsNumber = Integer.parseInt(springPoints);
            if(springPointsNumber > 0 && !spring.isEnrolled) {
                java.isEnrolled = true;
                // Update Course Info
                DataStore.courses.get(3).increaseCount().addPoints(springPointsNumber);
            }
            DataStore.courses.get(3).addPoints(springPointsNumber);
            spring.addCurrentPoints(springPointsNumber);
        }
    }

    public void printPoints(String id) {
        System.out.printf("%s points: Java=%d; DSA=%d; Databases=%d; Spring=%d \n", id, courseList.get(0).currentPoints, courseList.get(1).currentPoints, courseList.get(2).currentPoints, courseList.get(3).currentPoints);
    }

    //Getter
    public String getEmail() {
        return email;
    }

    private void initCourses() {
        courseList.addAll(Stream.of(Course.values())
                .collect(Collectors.toList()));
    }
}