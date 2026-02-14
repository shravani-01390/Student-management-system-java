import java.io.Serializable;

public class Student implements Serializable {
    private int rollNo;
    private String name;
    private double marks;

    public Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public String toFileString() {
        return rollNo + "," + name + "," + marks;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo +
               ", Name: " + name +
               ", Marks: " + marks;
    }
}
