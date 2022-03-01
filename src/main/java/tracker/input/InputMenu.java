package tracker.input;

import java.util.Scanner;

public class InputMenu {

    public static String parseInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input == null || input.isEmpty() || input.isBlank()) input = "null";


        return input;
    }
}