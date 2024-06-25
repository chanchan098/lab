package com.example.dataExpansion.mapper;

import com.example.dataExpansion.bean.Employee;
import com.example.dataExpansion.bean.Salary;

import java.util.List;


public interface SystemMapper {
    List<Employee> queryEmployees();

    List<Integer> queryEmployeeIds();

    void insertEmployees(List<Employee> employees);

    List<Salary> querySalaries();

    void insertSalaries(List<Salary> salaries);

    Integer queryMaxNoOfEmployees();
}