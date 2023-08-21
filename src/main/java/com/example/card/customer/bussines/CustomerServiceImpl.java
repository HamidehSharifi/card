package com.example.card.customer.bussines;

import com.example.card.customer.persistance.Customer;
import com.example.card.customer.persistance.CustomerRepository;
import com.example.card.customer.presentention.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.prefs.BackingStoreException;

@Service
public class CustomerServiceImpl implements CustomerService {


    private CustomerRepository customerRepository;
    private CustomerService customerService;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @Override
    public CustomerModel loggin(CustomerModel customerModel) {
//
        //  CustomerModel customerModel=new CustomerModel();

        Customer customer = customerRepository.findByUserName(customerModel.getUserName());
        if (customer == null) {
         throw  new BusinessException(BusinessExceptionKeyImpl.USER_NOT_FOUND));
        } else {
            Customer customer1 = new Customer();
            customer1.setEmail(customerModel.getEmail());
            customer1.setUserName(customerModel.getUserName());
            customerRepository.save(customer1);
        }
        return customerModel;
    }
}