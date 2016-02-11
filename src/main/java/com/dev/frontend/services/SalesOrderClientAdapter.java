package com.dev.frontend.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

public class SalesOrderClientAdapter {

	private static final String SALES_ORDER_APP = "http://localhost:8080/SalesOrderApp/";

	public static <T> List<T> getList(String path, Class<T> clas) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		Response response = client.target(SALES_ORDER_APP + path).request()
				.get();
		return response.readEntity(new GenericType<ArrayList<T>>() {
		});
	}

	public static <T> T get(String path, Class<T> clas) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		Response response = client.target(SALES_ORDER_APP + path).request()
				.get();
		return response.readEntity(new GenericType<T>() {
		});
	}

	public static <T> void save(String path, T data) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		Response response = client.target(SALES_ORDER_APP + path).request()
				.post(Entity.entity(data, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
	}

	public static <T> void delete(String path) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		Response response = client.target(SALES_ORDER_APP + path).request()
				.delete();
		System.out.println(response.getStatus());
	}
	//
	// public static void main(String[] args) {
	// String path = "customers";
	// List<Customer> customers = getList(path,
	// new GenericType<ArrayList<Customer>>() {
	// });
	// System.out.println(customers.get(0).getAddress());
	//
	// List<Customer> list = getList(path, Customer.class);
	//
	// Customer customer = get(path + "/1", new GenericType<Customer>() {
	// });
	// System.out.println(customer.getAddress());
	//
	// Customer data = new Customer();
	// data.setAddress("address11111");
	// data.setCode(100);
	// save(path, data);
	//
	// delete(path + "/1");
	// }

}
