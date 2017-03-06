package org.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.models.Customer;
import org.models.CustomerOrder;
import org.models.CustomerOrders;

public class OrderResponse implements JsonTransformer<CustomerOrders, List<Customer>> {

	private List<Customer> customers = null;
	
	public OrderResponse(final List<Customer> customers) {
		this.customers = customers;
	}
	
	@Override
	public CustomerOrders transform() {
		
		CustomerOrders orders = new CustomerOrders();
		
		List<CustomerOrder> orderList = new ArrayList<CustomerOrder>();
		
		Map<String, String> names = new HashMap<String, String>();
		
		for (Customer c: customers) {
		
			if (names.get(c.getName()) == null) {
				
				CustomerOrder order = new CustomerOrder();
				order.setName(c.getName());
				
				orderList.add(order);
				names.put(c.getName(), c.getName());
			}
		}
		
		orders.setOrders(orderList);
		
		return orders;
	}

	@Override
	public List<Customer> getInput() {
		return customers;
	}
}
