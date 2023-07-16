package lab4c;

import java.util.ArrayList;
import java.util.List;

public class Commissioned extends Employee {
    private double commission;
    private double baseSalary;

    private List<Order> orderList = new ArrayList<>();

    public Commissioned(int empId, double commission, double baseSalary) {
        super(empId);
        this.commission = commission;
        this.baseSalary = baseSalary;
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    //Need to adjust the formula
    @Override
    double calcGrossPay(int month, int year) {
        int orderAmt = 0;
        for (Order order : orderList) {
            if (order.getOrderDate().getMonthValue() == month && order.getOrderDate().getYear() == year) {
                orderAmt++;
            }
        }
        return baseSalary + (orderAmt * commission);
    }
}
