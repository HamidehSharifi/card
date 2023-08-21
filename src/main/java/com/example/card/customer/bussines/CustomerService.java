package com.example.card.customer.bussines;

import com.example.card.customer.presentention.CustomerModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface CustomerService {
    CustomerModel loggin (CustomerModel customerModel);

}
