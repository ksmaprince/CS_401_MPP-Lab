package lab_practice3;

import java.util.ArrayList;
import java.util.List;

public class Student extends Role {
    private double GPA;
    private List<Course> courses;

    public Student(double GPA) {
        this.GPA = GPA;
        courses = new ArrayList<>();
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    @Override
    public double getSalary() {
        return 0;
    }

    @Override
    public double getUnits() {
        double totalUnit = 0;
        for (Course cours : courses) {
            totalUnit += cours.getUnits();
        }
        return totalUnit;
    }
}
