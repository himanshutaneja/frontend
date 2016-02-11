package com.dev.frontend.services;

import java.util.Set;

public class SaleOrders {

	private int orderNo;
	private int custCode;
	private Set<LineItems> lineItems;
	private Customer customer;
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getCustCode() {
		return custCode;
	}
	public void setCustCode(int custCode) {
		this.custCode = custCode;
	}
	public Set<LineItems> getLineItems() {
		return lineItems;
	}
	public void setLineItems(Set<LineItems> lineItems) {
		this.lineItems = lineItems;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "SaleOrders [orderNo=" + orderNo + ", custCode=" + custCode + ", lineItems=" + lineItems + ", customer="
				+ customer + "]";
	}
}
