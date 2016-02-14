package com.dev.frontend.services;

public class LineItems {

	private int listItemCode;
	private String listItemQty;
	private String listOrderNo;
	private String listProductId;
	private Product product;

	public int getListItemCode() {
		return listItemCode;
	}

	public String getListItemQty() {
		return listItemQty;
	}

	public void setListItemQty(String listItemQty) {
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

	@Override
	public String toString() {
		return "LineItems [listItemCode=" + listItemCode + ", listItemQty=" + listItemQty + ", listOrderNo="
				+ listOrderNo + ", listProductId=" + listProductId + ", product=" + product + "]";
	}


}
