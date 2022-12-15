package com.example.thuchanh.service;

import com.example.thuchanh.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class CustomerService {
    private static List<Customer> listCustomer;
    private static long index;
    static {
        listCustomer = new ArrayList<Customer>();
        listCustomer.add(new Customer(1L,"Nguyen Van A","nguyena@gmail.com","HN"));
        listCustomer.add(new Customer(2L,"Nguyen Van B","nguyenb@gmail.com","HN"));
        listCustomer.add(new Customer(3L,"Nguyen Van C","nguyenc@gmail.com","HN"));
        index = listCustomer.get(listCustomer.size()-1).getId();
    }
    public List<Customer> findAllCustomer(){
        return listCustomer;
    }
    public Customer findById(long id){
        for(Customer c : listCustomer){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }
    public void save(Customer customer){
        listCustomer.add(new Customer(++index,customer.getName(),customer.getEmail(),customer.getAddress()));
    }
    public void update(Customer customer){
        Customer ct =  findById(customer.getId());
        ct.setName(customer.getName());
        ct.setEmail(customer.getEmail());
        ct.setAddress(customer.getAddress());
    }
    public void delete(Customer customer){
        listCustomer.remove(customer);
    }
    public List<Customer> search(String search){
        List<Customer> listSearch = new ArrayList<Customer>();
        for(Customer c : listCustomer){
            if(c.getName().toUpperCase().contains(search)){
                listSearch.add(c);
            }
        }
        return listSearch;
    }
}
