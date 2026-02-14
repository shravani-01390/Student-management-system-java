import java.io.*;
import java.util.*;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private final String FILE_NAME = "students.txt";

    public void addStudent(Student student) {
        students.add(student);
        saveToFile(student);
    }

    private void saveToFile(Student student) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(student.toFileString() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    public void loadStudents() {
        students.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                students.add(new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        Double.parseDouble(data[2])
                ));
            }
        } catch (IOException e) {
            System.out.println("No previous data found.");
        }
    }

    public void displayStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void searchStudent(int rollNo) {
        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                System.out.println("Student Found: " + s);
                return;
            }
        }
        System.out.println("Student Not Found!");
    }

    public void sortByMarks() {
        students.sort(Comparator.comparingDouble(Student::getMarks));
        System.out.println("Students sorted by marks.");
    }
}

