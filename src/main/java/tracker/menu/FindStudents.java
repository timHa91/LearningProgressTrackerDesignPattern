package tracker.menu;

import tracker.DataStore;
import tracker.text.Message;

import static tracker.text.Message.*;
import static tracker.input.InputMenu.parseInput;

public class FindStudents implements MenuStatus{
    @Override
    public void run() {
        printMessage(Message.FIND);

        while (true) {
            String inputId = parseInput();
            if (inputId.contains("back")) {
                break;
            }
            // Checks if entered id exists and prints points
            if (DataStore.checkIfIdExists(inputId)) {
                DataStore.getStudentFromId(inputId).printPoints(inputId);
            } else
                printFormatMessageWithString(STUDENT_NOT_FOUND_WITH_ID, inputId);
        }
    }
}
