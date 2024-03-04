package com.ahmethan.project.response;


import com.ahmethan.project.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceWithEmployeeResponse {
    private String productName;
    private double amount;
    private String invoiceNo;
    private EmployeeDto employeeDto;


}
