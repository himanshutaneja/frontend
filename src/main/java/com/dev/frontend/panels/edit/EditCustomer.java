package com.dev.frontend.panels.edit;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.dev.frontend.services.Customer;
import com.dev.frontend.services.Services;
import com.dev.frontend.services.Utils;

public class EditCustomer extends EditContentPanel 
{
	private static final long serialVersionUID = -8971249970444644844L;
	private JTextField txtCode = new JTextField();
	private JTextField txtName = new JTextField();
	private JTextField txtAddress = new JTextField();
	private JTextField txtPhone1 = new JTextField();
	private JTextField txtPhone2 = new JTextField();
	private JTextField txtCreditLimit = new JTextField();
	private JTextField txtCurrentCredit = new JTextField();

	public EditCustomer() 
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(new JLabel("Code"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(txtCode, gbc);
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		txtCode.setColumns(10);
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(new JLabel("Name"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		add(txtName, gbc);
		txtName.setColumns(28);
		
		
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(new JLabel("Address"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		add(txtAddress, gbc);
		txtAddress.setColumns(28);

		
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(new JLabel("Phone 1"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		add(txtPhone1, gbc);
		txtPhone1.setColumns(10);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 3;
		add(new JLabel("Phone 2"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 15);
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		add(txtPhone2, gbc);
		txtPhone2.setColumns(10);
		
		
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(new JLabel("Credit Limit"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		add(txtCreditLimit, gbc);
		txtCreditLimit.setColumns(10);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 4;
		add(new JLabel("Current Credit"), gbc);

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 15);
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		add(txtCurrentCredit, gbc);
		txtCurrentCredit.setColumns(10);
		txtCurrentCredit.setEditable(false);

	}
	
	@SuppressWarnings("rawtypes")
	public boolean bindToGUI(Object o) 
	{
		Map map =(LinkedHashMap)o;
		txtCode.setText(String.valueOf(map.get("code")));
		txtName.setText(String.valueOf(map.get("name")));
		txtPhone1.setText(String.valueOf(map.get("phone1")));
		txtPhone2.setText(String.valueOf(map.get("phone2")));
		txtAddress.setText(String.valueOf(map.get("code")));
		txtCreditLimit.setText(String.valueOf(map.get("creditLimit")));
		txtCurrentCredit.setText(String.valueOf(map.get("currentLimit")));
		return true;
	}

	public Object guiToObject() 
	{
		Customer customer = new Customer();
		customer.setName(txtName.getText());
		customer.setAddress(txtAddress.getText());
		customer.setPhone1(txtPhone1.getText());
		customer.setPhone2(txtPhone2.getText());
		customer.setCreditLimit(Utils.parseInt(txtCreditLimit.getText()));
		customer.setCurrentLimit(Utils.parseInt(txtCurrentCredit.getText()));
		return customer;
	}

	@Override
	public int getObjectType() 
	{
		return Services.TYPE_CUSTOMER;
	}

	@Override
	public String getCurrentCode() 
	{
		return txtCode.getText();
	}

	public void clear() 
	{
		txtCode.setText("");
		txtName.setText("");
		txtPhone1.setText("");
		txtPhone2.setText("");
		txtAddress.setText("");
		txtCreditLimit.setText("");
		txtCurrentCredit.setText("");
	}

	public void onInit() 
	{
		
	}
}
