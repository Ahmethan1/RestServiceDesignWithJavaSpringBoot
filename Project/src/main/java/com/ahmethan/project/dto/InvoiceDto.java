package com.ahmethan.project.dto;


import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {
    private String productName;
    private double amount;
    private String invoiceNo;
    private EmployeeDto employeeDto;


}

