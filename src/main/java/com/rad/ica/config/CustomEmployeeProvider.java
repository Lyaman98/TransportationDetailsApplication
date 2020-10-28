package com.rad.ica.config;

import com.rad.ica.domain.Employee;
import com.rad.ica.domain.Role;
import com.rad.ica.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CustomEmployeeProvider implements AuthenticationProvider {

    @Autowired
    private EmployeeService employeeService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String password = (String) authentication.getCredentials();
        String username = (String) authentication.getPrincipal();

        Optional<Employee> optional = employeeService.findByUsername(username);

        if (optional.isPresent()) {
            Employee employee = optional.get();
            if (employee.getUsername().equals(username) && employee.getPassword().equals(password)) {


                Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
                for (Role role : employee.getRoles()){
                    grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
                }


                return new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
            }else {
                throw new BadCredentialsException("Bad Credentials");
            }
        }

        throw new UsernameNotFoundException("Username not found");

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
