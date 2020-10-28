package com.rad.ica.controller;

import com.rad.ica.config.CustomEmployeeProvider;
import com.rad.ica.domain.Employee;
import com.rad.ica.repository.RoleRepository;
import com.rad.ica.service.EmployeeService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private EmployeeService employeeService;
    private CustomEmployeeProvider provider;
    private RoleRepository roleRepository;

    public LoginController(EmployeeService employeeService, CustomEmployeeProvider provider, RoleRepository roleRepository) {
        this.employeeService = employeeService;
        this.provider = provider;
        this.roleRepository = roleRepository;
    }


//    @PostMapping("/sign-in")
//    public String save(@ModelAttribute("employee") Employee employee){
//
//        Role role = new Role();
//        role.setRole("ADMIN");
//        roleRepository.save(role);
//        employee.getRoles().add(roleRepository.findByRole("ADMIN"));
//        employeeService.save(employee);
//
//        return "login";
//    }

    @GetMapping("/sign-in")
    public String getForm(Model model) {

        model.addAttribute("employee", new Employee());

        return "login";
    }

    @PostMapping("/sign-in")
    public String login(@ModelAttribute Employee employee) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(employee.getUsername(), employee.getPassword());

        Authentication authentication = provider.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        System.out.println("HERE" + SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return "redirect:/api/transport-requests";
    }
}
