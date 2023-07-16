package lab2.pro2A.extpackage;

import lab2.pro2A.GradeReport;
import lab2.pro2A.Student;

public class Main {
    public static void main(String[] args) {
        Student std1 = new Student("John");
        Student std2 = new Student("John");
        Student std3 = new Student("John");
        Student std4 = new Student("John");

        System.out.println("Student Name: "+std1.getName());

        GradeReport grp1 = std1.getGradeReport();

        System.out.println("Owner of Report: "+grp1.getStudent());
    }
}
