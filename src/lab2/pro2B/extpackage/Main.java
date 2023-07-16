package lab2.pro2B.extpackage;

import lab2.pro2B.Order;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(1);

        order.addOrderLine("AAA");
        order.addOrderLine("BBB");
        order.addOrderLine("CCC");

        System.out.println(order.getOrderLines());
    }
}
