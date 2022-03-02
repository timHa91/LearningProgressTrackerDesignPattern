package tracker;

import java.util.*;

import static tracker.Message.printMessage;

public class DataStore {

    private static Map<String, Student> students = new HashMap<>();

    public static boolean addStudentToDataStore(Student newStudent) {
        if(!checkIfEmailAlreadyInUse(newStudent.getEmail())){
            String id = generateUniqueId();
            // Loop till find a unique ID
            while (id == null){
                id = generateUniqueId();
            }
            students.put(id, newStudent);
            return true;
        }
        return false;
    }

    private static String generateUniqueId() {
        final String id = UUID.randomUUID().toString().substring(0, 5);
        if(checkIfIdExists(id)) return null;
        else return id;
    }

    private static boolean checkIfEmailAlreadyInUse(String email) {
        return students.entrySet().stream().anyMatch(value -> value.getValue().getEmail().equals(email));
    }

    public static void printListOfStudents() {
        if(students.size() == 0){
            printMessage(Message.STUDENT_NOT_FOUND);
        }
        else {
            printMessage("Students:");
            students.keySet().forEach(key -> printMessage(key));
        }
    }

    public static boolean checkIfIdExists(String id) {return students.containsKey(id);}
    public static Student getStudentFromId(String id) {return students.get(id);}
}
