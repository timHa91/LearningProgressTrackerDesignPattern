package tracker.menu;

import tracker.Message;

import static tracker.Message.printMessage;

public class Menu {
    MenuStatus menuStatus;
    public void printMenu(String userInput) {
        switch(userInput) {
            case "exit":
                setMenuStatus(new Exit());
                runStatus();
                break;
            case "back":
                setMenuStatus(new Back());
                runStatus();
                break;
            case "null":
                setMenuStatus(new Blank());
                runStatus();
                break;
            case "add students":
                setMenuStatus(new AddStudents());
                runStatus();
                break;
            case "list":
                setMenuStatus(new ListStudents());
                runStatus();
            case "find":
                setMenuStatus(new FindStudents());
                runStatus();
                break;
            case "add points":
                setMenuStatus(new AddPoints());
                runStatus();
                break;
            case "statistics":
                setMenuStatus(new Statistics());
                runStatus();
                break;
            default:
                setMenuStatus(new Unknown());
                runStatus();
                break;
        }
    }
    private void setMenuStatus(MenuStatus mS) {
        menuStatus = mS;
    }
    private void runStatus() {
        menuStatus.run();
    }
}
