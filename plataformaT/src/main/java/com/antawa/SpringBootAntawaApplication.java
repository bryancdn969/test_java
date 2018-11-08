package com.antawa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.antawa.config.WebConfig;
import com.antawa.model.CustomerInfo;
import com.antawa.model.ProductOrder;
import com.antawa.services.OrderService;

@SpringBootApplication
public class SpringBootAntawaApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAntawaApplication.class, args);
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
		OrderService orderService = (OrderService) context.getBean("orderService");
        orderService.sendOrderConfirmation(getDummyOrder());
        ((AbstractApplicationContext) context).close();
	}

	public static ProductOrder getDummyOrder(){
        ProductOrder order = new ProductOrder();
        order.setOrderId("1111");
        order.setProductName("Thinkpad T510");
        order.setStatus("confirmed");
         
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setName("Websystique Admin");
        customerInfo.setAddress("WallStreet");
        customerInfo.setEmail("bryan.cdn.20@gmail.com");
        order.setCustomerInfo(customerInfo);
        return order;
    }
}
