package com.dev.frontend.panels.list;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.dev.frontend.services.Services;

public class SalesOrderDataModel extends ListDataModel {
	private static final long serialVersionUID = 7526529951747614655L;

	public SalesOrderDataModel() {
		super(new String[] { "Order Number", "Customer", "Total Price" }, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_SALESORDER;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) {
		Object[] array = list.toArray();
		String[][] sampleData = new String[array.length][];
		for (int i = 0; i < array.length; i++) {
			sampleData[i] = new String[3];
			Map map = (LinkedHashMap) array[i];
			sampleData[i][0] = String.valueOf(map.get("orderNo"));
			sampleData[i][1] = "("
					+ String.valueOf(map.get("custCode"))
					+ ")"
					+ String.valueOf(((LinkedHashMap) map.get("customer"))
							.get("name"));
			List items = (ArrayList) map.get("lineItems");
			int totalPrice = 0;
			for (Object l : items) {
				Map lineItem = (LinkedHashMap) l;
				totalPrice = totalPrice + (Integer)(lineItem.get("listItemQty"))
						* (Integer)(((LinkedHashMap) lineItem.get("product")).get("price"));
			}
			sampleData[i][2] = String.valueOf(totalPrice);
		}
		return sampleData;
	}

}
