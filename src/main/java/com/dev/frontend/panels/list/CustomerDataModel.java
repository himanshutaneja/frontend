package com.dev.frontend.panels.list;

import java.util.List;

import com.dev.frontend.services.Customer;
import com.dev.frontend.services.Services;

public class CustomerDataModel extends ListDataModel
{
	private static final long serialVersionUID = 7526529951747613655L;

	public CustomerDataModel()
	{
		super(new String[] { "Code", "Name", "Phone", "Current Credit" }, 0);
	}

	@Override
	public int getObjectType()
	{
		return Services.TYPE_CUSTOMER;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list)
	{
		Object[] array = list.toArray();
		String[][] sampleData = new String[array.length][];
		for (int i = 0; i < array.length; i++) {
			sampleData[i] = new String[4];
			sampleData[i][0] = String.valueOf((((Customer) array[i]).getCode()));
			sampleData[i][1] = String.valueOf((((Customer) array[i]).getName()));
			sampleData[i][2] = String.valueOf((((Customer) array[i]).getPhone1()));
			sampleData[i][3] = String.valueOf((((Customer) array[i]).getCurrentLimit()));
		}
		return sampleData;
	}
}
