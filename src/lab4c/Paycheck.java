package lab4c;

public final class Paycheck {
    private final double grossPay;
    private final double fica = 0.23;
    private final double state = 0.05;
    private final double local = 0.01;
    private final double medicare = 0.03;
    private final double socialSecurity = 0.075;

    public Paycheck(double grossPay) {
        this.grossPay = grossPay;
    }

    public void print() {
        System.out.println("Net Payroll: " + getNetPay());
    }

    public double getNetPay() {
        double deduction = grossPay * (fica + state + local + medicare + socialSecurity);
        return grossPay - deduction;
    }
}
