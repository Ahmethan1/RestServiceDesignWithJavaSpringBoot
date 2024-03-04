package com.ahmethan.project.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvoiceRequest {
    private String productName;
    private double amount;
    private String invoiceNo;
    private int employeeId;
}
