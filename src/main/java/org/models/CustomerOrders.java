package org.models;

import java.util.List;

public class CustomerOrders {

	private List<CustomerOrder> orders = null;

	public List<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<CustomerOrder> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "CustomerOrders [orders=" + orders + "]\n";
	}
	
}
