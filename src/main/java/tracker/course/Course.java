package tracker.course;

import java.util.stream.Stream;

public enum Course {
    JAVA(600, "java", false, false, 0),
    DSA(400, "dsa", false, false, 0),
    DATABASES(480, "databases", false, false, 0),
    SPRING(550, "spring", false, false, 0),
    UNKNOWN(0, "", false, false, 0),
    ;

    public final long totalPoints;
    public final String name;
    public int currentPoints;
    public boolean isEnrolled;
    public boolean isComplete;

    Course(long totalPoints, String name, boolean isEnrolled, boolean isComplete, int currentPoints) {
        this.totalPoints = totalPoints;
        this.name = name;
        this.isEnrolled = false;
        this.isComplete = false;
        this.currentPoints = 0;
    }

    public static Course findCourseByName(String name) {
        return Stream.of(Course.values())
                .filter(course -> course.name.equals(name.trim()))
                .findFirst()
                .orElse(Course.UNKNOWN);
    }

    public boolean isEnrolled() {
        return isEnrolled;
    }

    public void setEnrolled(boolean enrolled) {
        isEnrolled = enrolled;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void addCurrentPoints(int currentPoints) {
        this.currentPoints += currentPoints;
    }
}
