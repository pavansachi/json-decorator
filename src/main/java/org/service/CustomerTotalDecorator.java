package org.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.models.Customer;
import org.models.CustomerOrder;
import org.models.CustomerOrders;

public class CustomerTotalDecorator implements JsonTransformer<CustomerOrders, List<Customer>> {

	private JsonTransformer<CustomerOrders, List<Customer>> transformer2;
	private List<Customer> customers = null;
	
	public CustomerTotalDecorator(final JsonTransformer<CustomerOrders, List<Customer>> tf) {
		this.transformer2 = tf;
	}
	
	@Override
	public CustomerOrders transform() {

		List<Customer> customers = this.transformer2.getInput();
		this.customers = customers;
		CustomerOrders orders = this.transformer2.transform();
		
		Map<String, CustomerOrder> map = new HashMap<String, CustomerOrder>();
		
		for (CustomerOrder order: orders.getOrders()) {
			
			map.put(order.getName(), order);
		}
		
		for (Customer customer: customers) {
			
			if (map.get(customer.getName()) != null) {
				
				CustomerOrder order = map.get(customer.getName());
				
				double price = order.getPrice() + customer.getPrice();
				
				order.setPrice(price);
			}
		}
		
		return orders;
	}

	@Override
	public List<Customer> getInput() {
		return customers;
	}
	
}