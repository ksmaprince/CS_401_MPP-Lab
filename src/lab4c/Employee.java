package lab4c;

import java.time.LocalDate;

public abstract class Employee {
    private int empId;

    public Employee(int empId) {
        this.empId = empId;
    }

    public void print() {
        LocalDate now = LocalDate.now();
        System.out.println(calcCompensation(now.getMonthValue(), now.getYear()));
    }

    public Paycheck calcCompensation(int month, int year) {
        return new Paycheck(calcGrossPay(month, year));
    }

    abstract double calcGrossPay(int month, int year);
}
