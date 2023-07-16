package lab_practice3;

public class Course {
    private String id;
    private String title;
    private double units;

    public Course(String id, String title, double units) {
        this.id = id;
        this.title = title;
        this.units = units;
    }

    public double getUnits() {
        return units;
    }
}
