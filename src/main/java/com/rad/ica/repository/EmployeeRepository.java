package com.rad.ica.repository;

import com.rad.ica.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Optional<Employee> findByUsername(String username);

}
