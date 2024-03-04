package com.ahmethan.project.apiController;

import com.ahmethan.project.dto.EmployeeDto;
import com.ahmethan.project.entities.EmployeeEntity;
import com.ahmethan.project.request.CreateEmployeeRequest;
import com.ahmethan.project.request.UpdateEmployeeRequest;
import com.ahmethan.project.response.EmployeeResponse;
import com.ahmethan.project.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeesController {

    private final EmployeeService employeeService;


    @GetMapping("/AllEmployees")
    public ResponseEntity<List<EmployeeResponse>> getAll() {
        List<EmployeeResponse> employeeResponses = employeeService.getAll();
        return ResponseEntity.ok(employeeResponses);
    }

    @PostMapping("/EmployeeCreate")
    public ResponseEntity<EmployeeEntity> createEmployee(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest) {
        EmployeeEntity entity = employeeService.createEmployee(createEmployeeRequest);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") int id) {
        Boolean a = employeeService.deleteEmployee(id);
        return ResponseEntity.ok(a);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable("id") int id, @RequestBody UpdateEmployeeRequest request) {
        EmployeeResponse employeeResponse = employeeService.updateEmployee(id, request);
        return ResponseEntity.ok(employeeResponse);
    }


}

