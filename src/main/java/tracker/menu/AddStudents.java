package tracker.menu;

import tracker.DataStore;
import tracker.Message;
import tracker.Student;
import tracker.input.CredentialChecker;

import static tracker.Message.*;
import static tracker.input.InputMenu.parseInput;

public class AddStudents implements MenuStatus{
    @Override
    public void run() {
        printMessage(ADD_STUDENT);

        while (true) {
            int countAddedStudents = 0;
            String userInput = parseInput();
            // enter back to leave add students
            if(userInput.equals("back")) {
                printFormatMessageWithInt(Message.ADD_STUDENT_SUCCESS_TOTAL, countAddedStudents);
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
    }
}


