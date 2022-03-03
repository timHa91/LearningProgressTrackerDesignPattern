package tracker.menu;

import tracker.text.Message;

import static tracker.text.Message.printMessage;

public class Back implements MenuStatus{
    @Override
    public void run() {
        printMessage(Message.EXIT);
    }
}
