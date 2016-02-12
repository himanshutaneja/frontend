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
		// TODO by the candidate
		/*
		 * This method is called when you click delete button on an edit view
		 * the code parameter is the code of (Customer - PRoduct ) or order
		 * number of Sales Order and the type is identifier of the object type
		 * and may be TYPE_PRODUCT , TYPE_CUSTOMER or TYPE_SALESORDER
		 */
		return true;
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
		// TODO by the candidate
		/*
		 * This method is used to get unit price of product with the code passed
		 * as a parameter
		 */
		return 1;
	}
}
