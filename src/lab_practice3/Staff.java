package lab_practice3;

public class Staff extends Role{
    private double salary;

    public Staff(double salary) {
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public double getUnits() {
        return 0;
    }
}
