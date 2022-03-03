package tracker.menu;

import tracker.DataStore;


public class ListStudents implements MenuStatus{
    @Override
    public void run() {
        DataStore.printListOfStudents();
    }
}
