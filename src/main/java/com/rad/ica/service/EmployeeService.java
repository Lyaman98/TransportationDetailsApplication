package com.rad.ica.service;

import com.rad.ica.domain.Employee;
import com.rad.ica.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void save(Employee employee){
        employeeRepository.save(employee);
    }
    public Optional<Employee> findByUsername(String username){
        return employeeRepository.findByUsername(username);
    }

}
