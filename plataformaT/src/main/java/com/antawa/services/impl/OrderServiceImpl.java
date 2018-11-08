package com.antawa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antawa.model.ProductOrder;
import com.antawa.services.MailService;
import com.antawa.services.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
    MailService mailService;
 
    @Override
    public void sendOrderConfirmation(ProductOrder productOrder) {
        mailService.sendEmail(productOrder);
    }	
}
