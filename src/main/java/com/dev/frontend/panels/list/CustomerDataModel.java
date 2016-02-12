package com.dev.frontend.panels.list;

import java.util.List;

import com.dev.frontend.services.Customer;
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

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) {
		String[][] sampleData = new String[list.size()][];
		int i = 0;
		for (Object object : list) {
			sampleData[i] = new String[4];
			Customer customer = (Customer) object;
			sampleData[i][0] = customer.getCode();
			sampleData[i][1] = customer.getName();
			sampleData[i][2] = customer.getPhone1();
			sampleData[i][3] = customer.getCurrentLimit();
			i++;
		}
		return sampleData;
	}
}
