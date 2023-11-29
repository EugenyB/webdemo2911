package com.example.webdemo2911.repositories;

import com.example.webdemo2911.data.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}