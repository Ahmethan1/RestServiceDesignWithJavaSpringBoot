package com.ahmethan.project.mapper;

import com.ahmethan.project.dto.EmployeeDto;
import com.ahmethan.project.entities.EmployeeEntity;
import com.ahmethan.project.request.CreateEmployeeRequest;
import com.ahmethan.project.response.EmployeeResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface EmployeeMapper {
    EmployeeDto fromEmployeeEntityToEmployeeDto(EmployeeEntity entity);
    List<EmployeeResponse> fromEmployeeEntityListToResponseList(List<EmployeeEntity> employeeEntities);
    EmployeeEntity fromRequestToEmployeeEntity(CreateEmployeeRequest request);
    EmployeeResponse fromEmployeeEntityToEmployeeResponse(EmployeeEntity entity);
}
