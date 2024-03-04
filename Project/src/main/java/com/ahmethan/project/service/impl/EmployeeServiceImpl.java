package com.ahmethan.project.service.impl;

import ch.qos.logback.core.boolex.EvaluationException;
import com.ahmethan.project.entities.EmployeeEntity;
import com.ahmethan.project.exception.EmployeeNotFoundException;
import com.ahmethan.project.exception.EmployeeNotNullException;
import com.ahmethan.project.mapper.EmployeeMapper;
import com.ahmethan.project.repository.EmployeeRepository;
import com.ahmethan.project.request.CreateEmployeeRequest;
import com.ahmethan.project.request.UpdateEmployeeRequest;
import com.ahmethan.project.response.EmployeeResponse;
import com.ahmethan.project.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeResponse> getAll() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<EmployeeResponse> responses = employeeMapper.fromEmployeeEntityListToResponseList(employeeEntities);
        return responses;
    }


    @Override
    public EmployeeEntity createEmployee(CreateEmployeeRequest request) {
        EmployeeEntity employeeEntity = employeeMapper.fromRequestToEmployeeEntity(request);
        String email =request.getEmail();
        if (employeeRepository.existsByEmail(email)) {
            throw new EmployeeNotNullException("Email zaten var Yeni giriş deneyiniz");
        }
        if(request.getEmail().isEmpty() || request.getFirstName().isEmpty() || request.getLastName().isEmpty()){
            throw new EmployeeNotNullException("Boş Employee Alanları var");
        }

        return employeeRepository.save(employeeEntity);

    }


    public Boolean deleteEmployee(int id) {
        Optional<EmployeeEntity> entity = employeeRepository.findById(id);
        if (entity.isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        }
        throw new EmployeeNotFoundException("Employee Id Not Found");
    }

    @Override
    public EmployeeResponse updateEmployee(int id, UpdateEmployeeRequest employeeRequest) {
        Optional<EmployeeEntity> resultEmployee = employeeRepository.findById(id);
        if (resultEmployee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        String email =employeeRequest.getEmail();
        if (employeeRepository.existsByEmail(email)) {
            throw new EmployeeNotNullException("Email zaten var Yeni giriş deneyiniz");
        }
        EmployeeEntity employeeEntity = resultEmployee.get();
        employeeEntity.setFirstName(employeeRequest.getFirstName());
        employeeEntity.setLastName(employeeRequest.getLastName());
        employeeEntity.setEmail(employeeRequest.getEmail());
        employeeRepository.save(employeeEntity);
        return employeeMapper.fromEmployeeEntityToEmployeeResponse(employeeEntity);



    }

}
