package com.ahmethan.project.mapper;

import com.ahmethan.project.dto.EmployeeDto;
import com.ahmethan.project.entities.EmployeeEntity;
import com.ahmethan.project.entities.InvoiceEntity;
import com.ahmethan.project.request.CreateEmployeeRequest;
import com.ahmethan.project.request.CreateInvoiceRequest;
import com.ahmethan.project.request.UpdateEmployeeRequest;
import com.ahmethan.project.response.EmployeeResponse;
import com.ahmethan.project.response.InvoiceWithEmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    @Mapping(target = "employeeEntity.id",source = "request.employeeId")
    InvoiceEntity fromRequestToInvoiceEntity(CreateInvoiceRequest request);

    List<InvoiceWithEmployeeResponse> fromInvoiceEntityListToResponseList(List<InvoiceEntity> invoiceEntities);

    @Mapping(target ="employeeDto",source = "invoiceEntity.employeeEntity")
    InvoiceWithEmployeeResponse fromInvoiceEntityToResponse(InvoiceEntity invoiceEntity);

    EmployeeDto fromEmployeeEntityToEmployeeDto(EmployeeEntity entity);







}

