package com.example.thuchanh.service;

import com.example.thuchanh.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
    private static List<Employee> listEmployees ;
    private static long index ;
    static {
        listEmployees = new ArrayList<Employee>();
        listEmployees.add(new Employee(1L, "Nguyen Van A",1000));
        listEmployees.add(new Employee(2L, "Nguyen Van B",2000));
        listEmployees.add(new Employee(3L, "Nguyen Van C",1400));
        index = listEmployees.get(listEmployees.size() - 1).getId();
    }
    public List<Employee> findAllEmployees(){
        return listEmployees;
    }
    public void save(String name, double salary) {
        listEmployees.add(new Employee(++index,name, salary));
    }
    public Employee findById(long id) {
        for (Employee employee : listEmployees){
            if(employee.getId() == id){
                return employee;
            }
        }
        return null;
    }

}
