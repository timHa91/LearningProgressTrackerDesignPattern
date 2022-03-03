package tracker.menu;

import static tracker.text.Message.*;

public class Exit implements MenuStatus{

    @Override
    public void run() {
       printMessage(EXIT_SUCCESS);
       System.exit(0);
    }
}
