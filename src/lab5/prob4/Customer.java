package lab5.prob4;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Order> orders;
	public Customer(String name) {
		this.name = name;
		orders = new ArrayList<Order>();	
	}
	void addOrder(Order order) {
		orders.add(order);
	}
	String getName() {
		return name;
	}
	public List<Order> getOrders() {
		return orders;
	}
}
