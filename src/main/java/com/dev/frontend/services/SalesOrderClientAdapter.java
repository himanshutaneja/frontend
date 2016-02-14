package com.dev.frontend.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

public class SalesOrderClientAdapter {

	private static final String SALES_ORDER_APP = "http://localhost:8080/SalesOrderApp/";

	public static <T> List<Object> getCustomerList(String path) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		List<Customer> response = client.target(SALES_ORDER_APP + path).request()
				.get(new GenericType<ArrayList<Customer>>() {
				});
		Object[] array = response.toArray();
		return Arrays.asList(array);
	}

	public static <T> List<Object> getProductList(String path) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		List<Product> response = client.target(SALES_ORDER_APP + path).request()
				.get(new GenericType<ArrayList<Product>>() {
				});
		Object[] array = response.toArray();
		return Arrays.asList(array);
	}

	public static <T> List<Object> getSaleOrdersList(String path) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ArrayList<SaleOrders> response = client.target(SALES_ORDER_APP + path).request()
				.get(new GenericType<ArrayList<SaleOrders>>() {
				});
		Object[] array = response.toArray();
		return Arrays.asList(array);
	}

	public static <T> Object get(String path, Class<T> clas) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		T response = client.target(SALES_ORDER_APP + path).request().get(clas);
		return response;
	}

	public static <T> void save(String path, T data) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		Response response = client.target(SALES_ORDER_APP + path).request()
				.post(Entity.entity(data, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
	}

	public static <T> Response delete(String path) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		Response response = client.target(SALES_ORDER_APP + path).request().delete();
		System.out.println(response.getStatus());
		return response;
	}

	// @SuppressWarnings("deprecation")
	// public static <T> List<Object> getSaleOrdersList(String path) {
	// ClientResponse<SaleOrders[]> response = null;
	// try {
	// ClientRequest cr = new ClientRequest(SALES_ORDER_APP + path);
	// cr.accept("application/json");
	// response = cr.get(SaleOrders[].class);
	// ObjectMapper mapper =new ObjectMapper();
	// mapper.reader().withType(new TypeReference<List<SaleOrders>>() {
	// }).readValues(response.getEntity().toString(), SaleOrders.class);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// SaleOrders[] soArr = response.getEntity();
	// //System.out.println(so.length);
	// SaleOrders so = soArr[0];
	// Object[] array = { so };
	// return Arrays.asList(array);
	// }

	// public static void main(String[] args) {
	// saleOrdersList = SalesOrderClientAdapter.getSaleOrdersList("saleOrders");
	// // List<Object> saleOrdersList = sc.getSaleOrdersList("saleOrders");
	//
	// System.out.println();
	// }

}
