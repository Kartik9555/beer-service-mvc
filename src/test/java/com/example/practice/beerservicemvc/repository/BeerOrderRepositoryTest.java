package com.example.practice.beerservicemvc.repository;

import com.example.practice.beerservicemvc.entities.Beer;
import com.example.practice.beerservicemvc.entities.BeerOrder;
import com.example.practice.beerservicemvc.entities.BeerOrderShipment;
import com.example.practice.beerservicemvc.entities.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class BeerOrderRepositoryTest {

    @Autowired
    BeerOrderRepository beerOrderRepository;
    
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BeerRepository beerRepository;

    Beer beer;
    Customer customer;


    @BeforeEach
    void setUp() {
        customer = customerRepository.findAll().get(0);
        beer = beerRepository.findAll().get(0);
    }


    @Transactional
    @Test
    void testBeerOrders() {
        BeerOrder beerOrder = BeerOrder.builder()
            .customerRef("Test order")
            .customer(customer)
            .beerOrderShipment(BeerOrderShipment.builder()
                .trackingNumber("1234r")
                .build()
            )
            .build();

        BeerOrder savedBeerOrder = beerOrderRepository.save(beerOrder);

        System.out.println(savedBeerOrder.getCustomerRef());
    }
}