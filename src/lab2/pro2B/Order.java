package lab2.pro2B;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNum;
    private List<OrderLine> orderLines = new ArrayList<>();

    public Order(int orderNum){
        this.orderNum = orderNum;

    }

    public void addOrderLine(String name){
        OrderLine orderLine = new OrderLine(name, this);
        orderLines.add(orderLine);
    }

    public int getOrderNum() {
        return orderNum;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    @Override
    public String toString() {
        return String.valueOf(orderNum);
    }
}
