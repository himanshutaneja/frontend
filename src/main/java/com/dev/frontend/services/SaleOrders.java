package com.dev.frontend.services;

import java.util.Set;


public class SaleOrders {

	private String orderNo;
	private String custCode;
	private Set<LineItems> lineItems;
	private Customer customer;
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setCustCode(String custCode) {
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
	
	@Override
	public String toString() {
		return "SaleOrders [orderNo=" + orderNo + ", custCode=" + custCode + ", lineItems=" + lineItems + ", customer="
				+ customer + "]";
	}
}
