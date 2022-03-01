package tracker.menu;

import static tracker.Message.*;

public class Blank implements MenuStatus{
    @Override
    public void run() {
        printMessage(NO_INPUT);
    }
}
