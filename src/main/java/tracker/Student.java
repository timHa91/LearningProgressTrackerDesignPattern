package tracker;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private int javaProgress;
    private int dsaProgress;
    private int dataBaseProgress;
    private int springProgress;

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void addLearningProgress(String java, String dsa, String dataBase, String spring) {
        this.javaProgress += Integer.parseInt(java);
        this.dsaProgress += Integer.parseInt(dsa);
        this.dataBaseProgress += Integer.parseInt(dataBase);
        this.springProgress += Integer.parseInt(spring);
    }

    public void printPoints(String id) {
        System.out.printf("%s points: Java=%d; DSA=%d; Databases=%d; Spring=%d", id, this.javaProgress, this.dsaProgress, this.dataBaseProgress, this.springProgress);
    }

    //Getter
    public String getEmail() {
        return email;
    }
    public int getJavaProgress() { return javaProgress; }
    public int getDsaProgress() { return dsaProgress; }
    public int getDataBaseProgress() { return dataBaseProgress; }
    public int getSpringProgress() { return springProgress; }
}