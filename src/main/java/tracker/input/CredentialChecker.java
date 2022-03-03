package tracker.input;

import tracker.text.Message;
import tracker.Student;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static tracker.text.Message.printMessage;

public class CredentialChecker {

    private static final String REGEX_FIRST_NAME = "^(([A-Za-z]{2,})|([A-Za-z]+[\\-'][A-Za-z]+))+$";
    private static final String REGEX_LAST_NAME = "^(([A-Za-z]{2,})|([A-Za-z]+[\\-'\\s][A-Za-z]+)[\\s-]*)+$";
    private static final String REGEX_EMAIL = "([\\w.-]+\\@\\w+\\.\\w+)$";

    public static Student checkIfCredentialsCorrect(String inputString) {
        String[] inputParts = inputString.split("\\s+");

        if (inputParts.length < 3) {
            printMessage(Message.ADD_STUDENT_ERROR_CREDENTIALS);
            return null;
        }

        String firstName = inputParts[0];
        if (!checkFirstName(firstName)) {
            printMessage(Message.ADD_STUDENT_ERROR_FIRST_NAME);
            return null;
        }

        String email = inputParts[inputParts.length - 1];
        if (!checkEmail(email)) {
            printMessage(Message.ADD_STUDENT_ERROR_EMAIL);
            return null;
        }

        String lastName = inputString.split(email)[0].strip().split("\\s+", 2)[1];
        if (!checkLastName(lastName)) {
            printMessage(Message.ADD_STUDENT_ERROR_LAST_NAME);
            return null;
        }

        return new Student(firstName, lastName, email);
    }


    private static boolean checkFirstName(String firstName) {
        Pattern patternName = Pattern.compile(REGEX_FIRST_NAME);
        Matcher matcherFirstName = patternName.matcher(firstName);
        if (!matcherFirstName.matches()) {
            return false;
        }
        return true;
    }

    private static boolean checkLastName(String lastName) {
        Pattern patternName = Pattern.compile(REGEX_LAST_NAME);
        Matcher matcherLastName = patternName.matcher(lastName);
        if (!matcherLastName.matches()) {
            return false;
        }
        return true;
    }

    private static boolean checkEmail(String email) {
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(email);
        if (!matcherEmail.matches()) {
            return false;
        }
        return true;
    }
}
