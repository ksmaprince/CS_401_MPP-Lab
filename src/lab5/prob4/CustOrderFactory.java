package lab5.prob4;

import java.time.LocalDate;

public class CustOrderFactory {
    private CustOrderFactory(){}

    public static Customer createCustomer(String name){
        if (name==null) throw new NullPointerException("Name cannot be null");
        return new Customer(name);
    }

    public static Order newOrder(Customer cust, LocalDate orderDate){
        return Order.newOrder(cust,orderDate);
    }
    public static void addOrder(Customer cust, Order order){
        cust.addOrder(order);
    }

    public static Item newItem(String name){
        return new Item(name);
    }

    public static void addItem(Order order, Item item){
        order.addItem(item.name);
    }
}
