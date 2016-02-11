package com.dev.frontend.services;

public class LineItems {


	private int listItemCode;
	private int listItemQty;
	private String listOrderNo;
	private String listProductId;
	private Product product;
	private SaleOrders saleOrder;

	public int getListItemCode() {
		return listItemCode;
	}

	public void setListItemCode(int listItemCode) {
		this.listItemCode = listItemCode;
	}

	public int getListItemQty() {
		return listItemQty;
	}

	public void setListItemQty(int listItemQty) {
		this.listItemQty = listItemQty;
	}

	public String getListOrderNo() {
		return listOrderNo;
	}

	public void setListOrderNo(String listOrderNo) {
		this.listOrderNo = listOrderNo;
	}

	public String getListProductId() {
		return listProductId;
	}

	public void setListProductId(String listProductId) {
		this.listProductId = listProductId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public SaleOrders getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(SaleOrders saleOrder) {
		this.saleOrder = saleOrder;
	}

	@Override
	public String toString() {
		return "LineItems [listItemCode=" + listItemCode + ", listItemQty="
				+ listItemQty + ", listOrderNo=" + listOrderNo
				+ ", listProductId=" + listProductId + ", product=" + product
				+ ", saleOrder=" + saleOrder + "]";
	}

}
