package com.example.thuchanh2.service;

import com.example.thuchanh2.model.Customer;

public interface  ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
