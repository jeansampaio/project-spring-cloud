package com.wysoft.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackMethodController {

    @RequestMapping("/orderServiceFallBack")
    public Mono<String> orderServiceFallBack() {
        return Mono.just("Order Service is taking too long to respond or is down." +
                " Please try again later");
    }
    @RequestMapping("/paymentServiceFallback")
    public Mono<String> paymentServiceFallBack() {
        return Mono.just("Payment Service is taking too long to respond or is down." +
                " Please try again later");
    }

    @GetMapping("/userServiceFallBack")
    public Mono<String> userServiceFallBack() {
        return Mono.just("User Service is talking longer than Expected." +
                " Please try again later");
    }

    @GetMapping("/departmentServiceFallBack")
    public Mono<String> departmentServiceFallBack() {
        return Mono.just("Department Service is talking longer than Expected." +
                " Please try again later");
    }
}
