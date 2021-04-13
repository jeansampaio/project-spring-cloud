package com.wysoft.api.order.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wysoft.api.order.common.Payment;
import com.wysoft.api.order.common.TransactionRequest;
import com.wysoft.api.order.common.TransactionResponse;
import com.wysoft.api.order.entity.Order;
import com.wysoft.api.order.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    @Lazy
    private RestTemplate template;

    @Value("${microservice.payment-service.endpoints.endpoint.uri:http://PAYMENT-SERVICE/payment/doPayment}")
    private String ENDPOINT_URL;

    public TransactionResponse saveOrder(TransactionRequest request) throws JsonProcessingException {

        Logger logger = LoggerFactory.getLogger(OrderService.class);

        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        logger.info("Order-Service Request : " + new ObjectMapper().writeValueAsString(request));

        // rest call
        Payment paymentResponse =
                template.postForObject(ENDPOINT_URL, payment, Payment.class);

        response = paymentResponse.getPaymentStatus().equals("sucess")?
                "payment processing successful and order placed":"there is a failure in payment api, order added to card";

        logger.info("Order Service getting Response from Payment-Service : " + new ObjectMapper().writeValueAsString(response));

        repository.save(order);

        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }
}
