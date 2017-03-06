package org.service;

import java.io.IOException;
import java.util.List;

import org.models.Customer;
import org.models.CustomerOrders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Main application
 * @author pavansachi
 *
 */

public class Application {

	public static void main(String[] args) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		String strCustomerList = "["
				+ "{\"name\":\"Alex\", \"orderId\":\"1000\", \"price\": 110},"
				+ "{\"name\":\"Pavan\", \"orderId\":\"1002\", \"price\": 205},"
				+ "{\"name\":\"Alex\", \"orderId\":\"1004\", \"price\": 130}"
				+ "]";
		
		List<Customer> customerList = mapper.readValue(strCustomerList, new TypeReference<List<Customer>>(){});
		
		JsonTransformer<CustomerOrders, List<Customer>> tf = new CustomerTotalDecorator(new OrderResponse(customerList));
		
		CustomerOrders orders = tf.transform();
		
		String strOrders = mapper.writeValueAsString(orders);
		
		System.out.println(strOrders);
	}

}