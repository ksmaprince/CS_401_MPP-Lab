package lab2.pro2A;

public class Student {
    private String name;
    private GradeReport gradeReport;

    public Student(String name){
        this.name = name;
        gradeReport = new GradeReport(this);
    }

    public String getName() {
        return name;
    }

    public GradeReport getGradeReport() {
        return gradeReport;
    }

    @Override
    public String toString() {
        return name;
    }
}
