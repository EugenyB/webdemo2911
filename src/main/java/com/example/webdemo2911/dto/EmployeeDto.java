package com.example.webdemo2911.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.webdemo2911.data.Employee}
 */
@Value
public class EmployeeDto implements Serializable {
    Integer id;
    String lastName;
    String firstName;
    String title;
    String reportsToLastName;
    String reportsToFirstName;
    String phone;
}