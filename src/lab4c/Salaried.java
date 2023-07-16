package lab4c;

public class Salaried extends Employee {
    private double salary;

    public Salaried(int empId, double salary) {
        super(empId);
        this.salary = salary;
    }

    @Override
    double calcGrossPay(int month, int year) {
        return salary;
    }
}
