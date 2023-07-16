package lab4c;

public class Hourly extends Employee {
    private static final int WEEKS_PER_MONTH = 4;

    private double hourlyWage;

    private double hoursPerWeek;

    public Hourly(int empId, double hourlyWage, double hoursPerWeek) {
        super(empId);
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    double calcGrossPay(int month, int year) {
        return hourlyWage * hoursPerWeek * WEEKS_PER_MONTH;
    }
}
