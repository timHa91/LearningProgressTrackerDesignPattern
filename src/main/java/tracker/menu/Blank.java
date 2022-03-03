package tracker.menu;

import static tracker.text.Message.*;

public class Blank implements MenuStatus{
    @Override
    public void run() {
        printMessage(NO_INPUT);
    }
}
