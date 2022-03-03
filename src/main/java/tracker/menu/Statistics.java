package tracker.menu;

import tracker.DataStore;
import tracker.course.CourseInfo;
import tracker.text.Message;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static tracker.text.Message.printMessage;

public class Statistics implements MenuStatus{
    @Override
    public void run() {
        printMessage(Message.STATISTICS);
        List<CourseInfo> mostPopular = findMostPopular(DataStore.courses);
        findLeastPopular(mostPopular);
        List<CourseInfo> highestActivity = findHighestActivity(DataStore.courses);
        findLowestActivity(highestActivity);
        findEasiestCourse(DataStore.courses);
        findHardestCourse(DataStore.courses);
    }

    private static List<CourseInfo> findMostPopular(List<CourseInfo> courses) {
        List<CourseInfo> list = courses.stream()
                .filter(x -> x.getPointsSum() != 0)
                .sorted(Comparator.comparingInt(CourseInfo::getPointsSum)
                        .reversed())
                .collect(Collectors.toList());
        String message = "n/a";
        if (!list.isEmpty()) {
            message = list.stream().map(CourseInfo::getTitle).collect(Collectors.joining(", "));
        }
        System.out.printf((Message.STATISTICS_MOST_POPULAR) + "%s\n", message);
        return list;
    }

    private static void findLeastPopular(List<CourseInfo> mostPopular) {
        List<CourseInfo> all = new ArrayList<>(DataStore.courses);
        all.removeAll(mostPopular);
        String message = "n/a";
        if (!all.isEmpty() && !mostPopular.isEmpty()) {
            message = all.stream().map(CourseInfo::getTitle).collect(Collectors.joining(", "));
        }
        System.out.printf((Message.STATISTICS_LEAST_POPULAR) + "%s\n", message);

    }

    private static List<CourseInfo> findHighestActivity(List<CourseInfo> courses) {
        List<CourseInfo> list = courses.stream()
                .filter(x -> x.getPointsCount() != 0)
                .sorted(Comparator.comparingInt(CourseInfo::getPointsCount)
                        .reversed())
                .collect(Collectors.toList());
        String message = "n/a";
        if (!list.isEmpty()) {
            message = list.stream().map(CourseInfo::getTitle).collect(Collectors.joining(", "));
        }
        System.out.printf((Message.STATISTICS_HIGHEST_ACTIVITY) + "%s\n", message);
        return list;
    }

    private static void findLowestActivity(List<CourseInfo> highestActivity) {
        List<CourseInfo> all = new ArrayList<>(DataStore.courses);
        all.removeAll(highestActivity);
        String message = "n/a";
        if (!all.isEmpty() && !highestActivity.isEmpty()) {
            message = all.stream().map(CourseInfo::getTitle).collect(Collectors.joining(", "));
        }
        System.out.printf((Message.STATISTICS_LOWEST_ACTIVITY) + "%s\n", message);
    }

    private static void findCourseByDifficulty(List<CourseInfo> courses, String difficulty) {
        CourseInfo courseInfo = courses.stream()
                .filter(x -> x.avg() > 0.0)
                .max(Comparator.comparingDouble(CourseInfo::avg))
                .orElse(null);
        String message = "n/a";
        if (courseInfo != null) {
            message = courseInfo.getTitle();
        }
        System.out.printf((difficulty) + "%s\n", message);
    }


    private static void findEasiestCourse(List<CourseInfo> courses) {
        CourseInfo courseInfo = courses.stream()
                .filter(x -> x.avg() > 0.0)
                .max(Comparator.comparingDouble(CourseInfo::avg))
                .orElse(null);
        String message = "n/a";
        if (courseInfo != null) {
            message = courseInfo.getTitle();
        }
        System.out.printf((Message.STATISTICS_EASIEST_COURSE) + "%s\n", message);
    }

    private static void findHardestCourse(List<CourseInfo> courses) {
        CourseInfo courseInfo = courses.stream()
                .filter(x -> x.avg() > 0.0)
                .min(Comparator.comparingDouble(CourseInfo::avg))
                .orElse(null);
        String message = "n/a";
        if (courseInfo != null) {
            message = courseInfo.getTitle();
        }
        System.out.printf((Message.STATISTICS_HARDEST_COURSE) + "%s\n", message);
    }

}
