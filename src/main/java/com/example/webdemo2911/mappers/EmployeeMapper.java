package com.example.webdemo2911.mappers;

import com.example.webdemo2911.data.Employee;
import com.example.webdemo2911.dto.EmployeeDto;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Service
public class EmployeeMapper {
    public EmployeeDto employeeToDto(Employee e) {
        if (e.getReportsTo() != null) {
            return new EmployeeDto(e.getId(), e.getLastName(), e.getFirstName(), e.getTitle(), e.getReportsTo().getLastName(), e.getReportsTo().getFirstName(), e.getPhone());
        } else {
            return new EmployeeDto(e.getId(), e.getLastName(), e.getFirstName(), e.getTitle(), "", "", e.getPhone());
        }
    }
}
