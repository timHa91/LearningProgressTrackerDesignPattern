package tracker.menu;

import tracker.DataStore;
import tracker.Message;

import static tracker.Message.*;
import static tracker.input.InputMenu.parseInput;
import static tracker.input.PointsChecker.checkPointsInput;

public class AddPoints implements MenuStatus{
    @Override
    public void run() {
        printMessage(Message.ADD_POINTS);

        // User Input
        while (true) {
            String userInput = parseInput();
            if (userInput.contains("back")) {
                break;
            }
            // Check the Format of the input
            String[] inputParts = checkPointsInput(userInput);
            // if valid add Points
            if (inputParts != null) {
                // 0 = ID, 1 = Java , 2 = DSA , 3 = Database, 4 = Spring
                DataStore.getStudentFromId(inputParts[0]).addLearningProgress(inputParts[1], inputParts[2], inputParts[3], inputParts[4]);
                printMessage(ADD_POINTS_SUCCESS);
            }
        }
    }
}
