package com.ahmethan.project.service;

import com.ahmethan.project.entities.InvoiceEntity;
import com.ahmethan.project.request.CreateInvoiceRequest;
import com.ahmethan.project.response.InvoiceWithEmployeeResponse;

import java.util.List;

public interface InvoiceService {
    List<InvoiceWithEmployeeResponse> getAll(int pageNo, int pageSize);

    InvoiceEntity createInvoice(CreateInvoiceRequest request);

    Boolean deleteInvoice(int id);


}

