package tracker.menu;

import static tracker.text.Message.*;

public class Unknown implements MenuStatus{
    @Override
    public void run() {
        printMessage(UNKNOWN_INPUT);
    }
}
