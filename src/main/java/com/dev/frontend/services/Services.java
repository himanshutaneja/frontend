package com.dev.frontend.services;

import java.util.ArrayList;
import java.util.List;

import com.dev.frontend.panels.ComboBoxItem;

public class Services {
	public static final int TYPE_PRODUCT = 1;
	public static final int TYPE_CUSTOMER = 2;
	public static final int TYPE_SALESORDER = 3;

	public static final String PATH_PRODUCT = "products";
	public static final String PATH_CUSTOMER = "customers";
	public static final String PATH_SALE_ORDER = "salesOrders";
	public static final int HTTP_SUCCESS = 200;

	public static Object save(Object object, int objectType) {
		if (objectType == TYPE_PRODUCT) {
			SalesOrderClientAdapter.save(PATH_PRODUCT, object);
		} else if (objectType == TYPE_CUSTOMER) {
			SalesOrderClientAdapter.save(PATH_CUSTOMER, object);
		} else {
			SalesOrderClientAdapter.save(PATH_SALE_ORDER, object);
		}
		return object;
	}

	public static Object readRecordByCode(String code, int objectType) {
		if (objectType == TYPE_PRODUCT) {
			return SalesOrderClientAdapter.get(PATH_PRODUCT.concat("/").concat(code), Product.class);
		} else if (objectType == TYPE_CUSTOMER) {
			return SalesOrderClientAdapter.get(PATH_CUSTOMER.concat("/").concat(code), Customer.class);
		} else {
			return SalesOrderClientAdapter.get(PATH_SALE_ORDER.concat("/").concat(code), SaleOrders.class);
		}
	}

	public static boolean deleteRecordByCode(String code, int objectType) {
		if (objectType == TYPE_PRODUCT) {
			return SalesOrderClientAdapter.delete(PATH_PRODUCT.concat("/").concat(code)).getStatus() == HTTP_SUCCESS;
		} else if (objectType == TYPE_CUSTOMER) {
			return SalesOrderClientAdapter.delete(PATH_CUSTOMER.concat("/").concat(code)).getStatus() == HTTP_SUCCESS;
		} else {
			return SalesOrderClientAdapter.delete(PATH_SALE_ORDER.concat("/").concat(code)).getStatus() == HTTP_SUCCESS;
		}
	}

	public static List<Object> listCurrentRecords(int objectType) {
		if (objectType == TYPE_PRODUCT) {
			return SalesOrderClientAdapter.getProductList(PATH_PRODUCT);
		} else if (objectType == TYPE_CUSTOMER) {
			return SalesOrderClientAdapter.getCustomerList(PATH_CUSTOMER);
		} else {
			return SalesOrderClientAdapter.getSaleOrdersList(PATH_SALE_ORDER);
		}
	}

	public static List<ComboBoxItem> listCurrentRecordRefernces(int objectType) {
		List<ComboBoxItem> dropdownList = new ArrayList<ComboBoxItem>();
		if (objectType == TYPE_PRODUCT) {
			List<Object> productList = SalesOrderClientAdapter.getProductList(PATH_PRODUCT);
			for (Object object : productList) {
				Product p = (Product) object;
				dropdownList.add(new ComboBoxItem(p.getCode(), p.getDescription()));
			}

		} else if (objectType == TYPE_CUSTOMER) {
			List<Object> customerList = SalesOrderClientAdapter.getCustomerList(PATH_CUSTOMER);
			for (Object object : customerList) {
				Customer p = (Customer) object;
				dropdownList.add(new ComboBoxItem(p.getCode(), p.getName()));
			}
		}
		return dropdownList;
	}

	public static double getProductPrice(String productCode) {
		Product p = (Product) SalesOrderClientAdapter.get(PATH_PRODUCT.concat("/").concat(productCode), Product.class);
		return Double.parseDouble(p.getPrice());
	}
}
