package com.dev.frontend.panels.list;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

	@SuppressWarnings("rawtypes")
	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) {
		Object[] array = list.toArray();
		String[][] sampleData = new String[array.length][];
		for (int i = 0; i < array.length; i++) {
			sampleData[i] = new String[4];
			Map map = (LinkedHashMap) array[i];
			sampleData[i][0] = String.valueOf(map.get("code"));
			sampleData[i][1] = String.valueOf(map.get("description"));
			sampleData[i][2] = String.valueOf(map.get("price"));
			sampleData[i][3] = String.valueOf(map.get("quantity"));
		}
		return sampleData;
	}
}
