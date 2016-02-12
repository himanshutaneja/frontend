package com.dev.frontend.services;

public class Utils
{
	public static Double parseDouble(String value)
	{
		if(value == null||value.isEmpty())
			return 0D;
		try
		{
			return Double.parseDouble(value);
		}
		catch(Exception e)
		{
			return 0D;
		}
	}
	
	public static Integer parseInt(String value)
	{
		if(value == null||value.isEmpty())
			return 0;
		try
		{
			return Integer.parseInt(value);
		}
		catch(Exception e)
		{
			return 0;
		}
	}
}
