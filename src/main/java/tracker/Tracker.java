package tracker;

import tracker.menu.Menu;

import static tracker.Message.*;
import static tracker.input.InputMenu.*;

public class Tracker {

    public static void startTracker(){
        printMessage(APP_TITLE);
        while (true) {
            Menu menu = new Menu();
            menu.printMenu(parseInput());
        }
    }
}
