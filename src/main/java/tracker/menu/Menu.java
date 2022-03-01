package tracker.menu;

public class Menu {
    MenuStatus menuStatus;

    public void printMenu(String userInput) {
        switch(userInput) {
            case "exit":
                setMenuStatus(new Exit());
                runStatus();
                break;
            case "null":
                setMenuStatus(new Blank());
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
