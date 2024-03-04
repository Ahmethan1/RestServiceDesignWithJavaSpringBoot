package com.ahmethan.project.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "public", name = "invoice")
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "product_name")
    @NotEmpty(message = "Isim bos bırakılamaz.")
    private String productName;
    @Column(name = "amount")
    private double amount;
    @Column(name = "invoice_no")
    @NotEmpty(message = "Isim bos bırakılamaz.")
    private String invoiceNo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeEntity;

}
