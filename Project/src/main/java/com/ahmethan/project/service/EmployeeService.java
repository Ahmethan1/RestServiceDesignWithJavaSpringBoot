package com.ahmethan.project.service;

import com.ahmethan.project.entities.EmployeeEntity;
import com.ahmethan.project.request.CreateEmployeeRequest;
import com.ahmethan.project.request.UpdateEmployeeRequest;
import com.ahmethan.project.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponse> getAll();

    EmployeeEntity createEmployee(CreateEmployeeRequest request);
    Boolean deleteEmployee(int id);
    EmployeeResponse updateEmployee(int id, UpdateEmployeeRequest employeeRequest);

}
