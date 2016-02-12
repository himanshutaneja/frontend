package com.dev.frontend.services;

import java.util.ArrayList;
import java.util.List;

import org.jboss.resteasy.util.GenericType;

import com.dev.frontend.panels.ComboBoxItem;

public class Services {
	public static final int TYPE_PRODUCT = 1;
	public static final int TYPE_CUSTOMER = 2;
	public static final int TYPE_SALESORDER = 3;

	public static final String PATH_PRODUCT = "products";
	public static final String PATH_CUSTOMER = "customers";
	public static final String PATH_SALE_ORDER = "salesOrders";

	public static Object save(Object object, int objectType) {
		// TODO by the candidate
		/*
		 * This method is called eventually after you click save on any edit
		 * screen object parameter is the return object from calling method
		 * guiToObject on edit screen and the type is identifier of the object
		 * type and may be TYPE_PRODUCT , TYPE_CUSTOMER or TYPE_SALESORDER
		 */
		return null;
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
			return SalesOrderClientAdapter.getList(PATH_PRODUCT, Product.class);
		} else if (objectType == TYPE_CUSTOMER) {
			return SalesOrderClientAdapter.getList(PATH_CUSTOMER, Customer.class);
		} else {
			return SalesOrderClientAdapter.getList(PATH_SALE_ORDER, SaleOrders.class);
		}
	}

	public static List<ComboBoxItem> listCurrentRecordRefernces(int objectType) {
		// TODO by the candidate
		/*
		 * This method is called when a Combo Box need to be initialized and
		 * should return list of ComboBoxItem which contains code and
		 * description/name for all records of specified type
		 */
		return new ArrayList<ComboBoxItem>();
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
