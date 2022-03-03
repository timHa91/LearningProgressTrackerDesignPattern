package tracker.text;

public class Message {

    public static final String EXIT_SUCCESS = "Bye!";
    public static final String EXIT = "Enter 'exit' to exit the program.";
    public static final String NO_INPUT = "No input.";
    public static final String UNKNOWN_INPUT = "Error: unknown command!";
    public static final String APP_TITLE = "Learning Progress Tracker";
    public static final String ADD_STUDENT = "Enter student credentials or 'back' to return";
    public static final String ADD_STUDENT_SUCCESS = "The student has been added.";
    public static final String ADD_STUDENT_SUCCESS_TOTAL = "Total %d students have been added.%n";
    public static final String ADD_STUDENT_ERROR_CREDENTIALS = "Incorrect credentials.";
    public static final String ADD_STUDENT_ERROR_EMAIL = "Incorrect email.";
    public static final String ADD_STUDENT_ERROR_FIRST_NAME = "Incorrect first name.";
    public static final String ADD_STUDENT_ERROR_LAST_NAME = "Incorrect last name.";
    public static final String EMAIL_TAKEN = "This email is already taken.";
    public static final String ADD_POINTS = "Enter an id and points or 'back' to return";
    public static final String STUDENT_NOT_FOUND = "No students found.";
    public static final String STUDENT_NOT_FOUND_WITH_ID = "No student is found for id=%s\n";
    public static final String ADD_POINTS_INVALID_FORMAT = "Incorrect points format";
    public static final String ADD_POINTS_SUCCESS = "Points updated";
    public static final String FIND = "Enter an id or 'back' to return:";
    public static final String STATISTICS = "Type the name of a course to see details or 'back' to quit:";
    public static final String STATISTICS_MOST_POPULAR = "Most popular: ";
    public static final String STATISTICS_LEAST_POPULAR = "Least popular: ";
    public static final String STATISTICS_HIGHEST_ACTIVITY = "Highest activity: ";
    public static final String STATISTICS_LOWEST_ACTIVITY = "Lowest activity: ";
    public static final String STATISTICS_EASIEST_COURSE = "Easiest course: ";
    public static final String STATISTICS_HARDEST_COURSE = "Hardest course: ";
    public static final String STATISTICS_UNKNOWN_COURSE = "Unknown course";

    public static void printMessage(String msg) {
        System.out.println(msg);
    }
    public static void printFormatMessageWithInt(String msg, int number) {System.out.printf(msg, number);}
    public static void printFormatMessageWithString(String msg, String id) {System.out.printf(msg, id);}
}
