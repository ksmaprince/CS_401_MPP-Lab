package lab2.pro2A;

public class GradeReport {
    private Student student;
    private String grade;
    GradeReport(Student student){
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
