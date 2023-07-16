package lab_practice3;

import lab3.prob3.Property;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends Role {
    private double salary;

    private List<Course> courses;

    public Faculty(double salary) {
        this.salary = salary;
        courses = new ArrayList<>();
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    @Override
    public double getSalary() {
        return salary;
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
