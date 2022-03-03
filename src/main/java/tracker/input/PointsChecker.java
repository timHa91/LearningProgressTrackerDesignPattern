package tracker.input;

import tracker.DataStore;
import tracker.text.Message;

import static tracker.text.Message.*;
import static tracker.text.Message.printMessage;

public class PointsChecker {
    public static String[] checkPointsInput(String inputPoints) {
        String[] inputParts = inputPoints.split("\\s+");
        // Check correct number of inputPoints
        if(inputParts.length != 5) {
            printMessage(Message.ADD_POINTS_INVALID_FORMAT);
            return null;
        }
        // Check if ID exists
        if(!DataStore.checkIfIdExists(inputParts[0])){
            printFormatMessageWithString(STUDENT_NOT_FOUND_WITH_ID, inputParts[0]);
            System.out.println("");
            return null;
        }
        // Check if every number has valid format
        for(int i = 1; i < inputParts.length; i++) {
            int points;
            try {
                points = Integer.parseInt(inputParts[i]);
            }
            catch (NumberFormatException e) {
                points = -1;
            }
            if(points < 0) {
                printMessage(Message.ADD_POINTS_INVALID_FORMAT);
                return null;
            }
        }
        return inputParts;
    }
}
