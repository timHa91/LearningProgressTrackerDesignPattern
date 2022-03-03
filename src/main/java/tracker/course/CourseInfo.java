package tracker.course;

public enum CourseInfo {

    JAVA_INFO("Java", 0, 0),
    DSA_INFO("DSA", 0, 0),
    DATABASE_INFO("Databases", 0, 0),
    SPRING_INFO("Spring", 0, 0);


    private final String title;
    private int pointsSum;
    private int pointsCount;


    CourseInfo(String title, int coursePopularity, int pointsCount) {
        this.title = title;
        this.pointsSum = coursePopularity;
        this.pointsCount = pointsCount;
    }

    public String getTitle() {
        return title;
    }

    public int getPointsSum() {
        return pointsSum;
    }

    public int getPointsCount() {
        return pointsCount;
    }

    public void addPoints(int points) {
        this.pointsSum += points;
    }

    public CourseInfo increaseCount() {
        this.pointsCount++;
        return this;
    }

    public double avg() {
        return (double) pointsSum / pointsCount;
    }
}
