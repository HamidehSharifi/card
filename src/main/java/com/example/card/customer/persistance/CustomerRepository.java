package com.example.card.customer.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer,Integer>,
        JpaSpecificationExecutorWithProjection<Customer>{

    Customer findByUserId(Integer userId);
    Customer findByUserName(String userName);
}
