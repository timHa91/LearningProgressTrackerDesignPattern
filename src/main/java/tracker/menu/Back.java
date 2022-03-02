package tracker.menu;

import tracker.Message;

import static tracker.Message.printMessage;

public class Back implements MenuStatus{
    @Override
    public void run() {
        printMessage(Message.EXIT);
    }
}
