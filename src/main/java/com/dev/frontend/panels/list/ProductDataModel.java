package com.dev.frontend.panels.list;

import java.util.List;

import com.dev.frontend.services.Product;
import com.dev.frontend.services.Services;

public class ProductDataModel extends ListDataModel {
	private static final long serialVersionUID = 7526529951747614655L;

	public ProductDataModel() {
		super(new String[] { "Code", "Description", "Price", "Quantity" }, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_PRODUCT;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) {
		Object[] array = list.toArray();
		String[][] sampleData = new String[array.length][];
		for (int i = 0; i < array.length; i++) {
			sampleData[i] = new String[4];
			Product prod = (Product) array[i];
			sampleData[i][0] = prod.getCode();
			sampleData[i][1] = prod.getDescription();
			sampleData[i][2] = prod.getPrice();
			sampleData[i][3] = prod.getQuantity();
		}
		return sampleData;
	}
}
