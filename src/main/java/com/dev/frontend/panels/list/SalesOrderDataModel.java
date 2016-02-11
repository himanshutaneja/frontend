package com.dev.frontend.panels.list;

import java.util.List;
import java.util.Set;

import com.dev.frontend.services.LineItems;
import com.dev.frontend.services.Product;
import com.dev.frontend.services.SaleOrders;
import com.dev.frontend.services.Services;


public class SalesOrderDataModel extends ListDataModel
{
	private static final long serialVersionUID = 7526529951747614655L;

	public SalesOrderDataModel() 
	{
		super(new String[]{"Order Number","Customer","Total Price"}, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_SALESORDER;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) 
	{
		Object[] array = list.toArray();
		String[][] sampleData = new String[array.length][];
		for (int i = 0; i < array.length; i++) {
			sampleData[i] = new String[3];
			sampleData[i][0] = String.valueOf((((SaleOrders) array[i]).getOrderNo()));
			sampleData[i][1] = String.valueOf((((SaleOrders) array[i]).getCustCode()));
			Set<LineItems> lineItems = ((SaleOrders)array[i]).getLineItems();
			int totalPrice =0;
			for(LineItems l : lineItems){
			 totalPrice =totalPrice + l.getListItemQty()*l.getProduct().getPrice();
			}
			sampleData[i][2] = String.valueOf(totalPrice);
		}
		return sampleData;
	}
	
}
