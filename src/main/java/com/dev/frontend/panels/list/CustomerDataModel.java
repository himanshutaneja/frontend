package com.dev.frontend.panels.list;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.dev.frontend.services.Services;

public class CustomerDataModel extends ListDataModel {
	private static final long serialVersionUID = 7526529951747613655L;

	public CustomerDataModel() {
		super(new String[] { "Code", "Name", "Phone", "Current Credit" }, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_CUSTOMER;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) {
		String[][] sampleData = new String[list.size()][];
		int i = 0;
		for (Object object : list) {
			sampleData[i] = new String[4];
			Map map = (LinkedHashMap) object;
			sampleData[i][0] = String.valueOf(map.get("code"));
			sampleData[i][1] = String.valueOf(map.get("name"));
			sampleData[i][2] = String.valueOf(map.get("phone1"));
			sampleData[i][3] = String.valueOf(map.get("currentLimit"));
			i++;
		}
		return sampleData;
	}
}
