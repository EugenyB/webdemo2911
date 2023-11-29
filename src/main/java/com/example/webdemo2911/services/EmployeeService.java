package com.example.webdemo2911.services;

import com.example.webdemo2911.data.Employee;
import com.example.webdemo2911.dto.EmployeeDto;
import com.example.webdemo2911.mappers.EmployeeMapper;
import com.example.webdemo2911.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper mapper;

    public List<EmployeeDto> getEmployees() {
        return employeeRepository.findAll().stream().map(mapper::employeeToDto).toList();
    }
}
