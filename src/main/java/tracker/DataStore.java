package tracker;

import tracker.course.CourseInfo;
import tracker.text.Message;

import java.util.*;
import java.util.stream.Collectors;

import static tracker.text.Message.printMessage;

public class DataStore {

    private static Map<String, Student> students = new HashMap<>();

    private static CourseInfo java = CourseInfo.JAVA_INFO;
    private static CourseInfo dsa = CourseInfo.DSA_INFO;
    private static CourseInfo db = CourseInfo.DATABASE_INFO;
    private static CourseInfo spring = CourseInfo.SPRING_INFO;
    public static List<CourseInfo> courses = Arrays.asList(java, dsa, db, spring);


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
