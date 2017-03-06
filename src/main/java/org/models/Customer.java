package org.models;

public class Customer {

	private String name;
	private String orderId;
	private double price;

	private Location shipTo;
	private Location billTo;

	public Customer() {

	}

	public Customer(final String name, 
			final String orderId,
			final double price) {

		this.name = name;
		this.orderId = orderId;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Location getShipTo() {
		return shipTo;
	}
	public void setShipTo(Location shipTo) {
		this.shipTo = shipTo;
	}
	public Location getBillTo() {
		return billTo;
	}
	public void setBillTo(Location billTo) {
		this.billTo = billTo;
	}

}
