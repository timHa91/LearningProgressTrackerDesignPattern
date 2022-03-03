package tracker.menu;

import tracker.DataStore;
import tracker.text.Message;
import tracker.Student;
import tracker.input.CredentialChecker;

import static tracker.text.Message.*;
import static tracker.input.InputMenu.parseInput;

public class AddStudents implements MenuStatus{
    @Override
    public void run() {
        printMessage(ADD_STUDENT);
        int countAddedStudents = 0;
        while (true) {
            String userInput = parseInput();
            // enter back to leave add students
            if(userInput.equals("back")) {
                break;
            }
            // Check the Format of the input and return a new Student
            Student newStudent = CredentialChecker.checkIfCredentialsCorrect(userInput);
            // if valid add Student to DataStore
            if (newStudent != null) {
                if (DataStore.addStudentToDataStore(newStudent)) {
                    printMessage(Message.ADD_STUDENT_SUCCESS);
                    countAddedStudents++;
                } else printMessage(Message.EMAIL_TAKEN);
            }
        }
        printFormatMessageWithInt(Message.ADD_STUDENT_SUCCESS_TOTAL, countAddedStudents);
    }
}


