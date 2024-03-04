package com.ahmethan.project.service.impl;

import com.ahmethan.project.entities.InvoiceEntity;
import com.ahmethan.project.exception.InvoiceLimitException;
import com.ahmethan.project.exception.InvoiceNotNullException;
import com.ahmethan.project.exception.MethodArgumentNotValidException;
import com.ahmethan.project.mapper.InvoiceMapper;
import com.ahmethan.project.repository.InvoiceRepository;
import com.ahmethan.project.request.CreateInvoiceRequest;
import com.ahmethan.project.response.InvoiceWithEmployeeResponse;
import com.ahmethan.project.service.InvoiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;
    @Value("${project.invoiceLimit}")
    private int invoiceLimit;
    private double totalInvoiceAmount = 0.0;

    @Override
    public List<InvoiceWithEmployeeResponse> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<InvoiceEntity> invoiceEntities = invoiceRepository.findAll(pageable);
        List<InvoiceEntity> listOfInvoice = invoiceEntities.getContent();
        List<InvoiceWithEmployeeResponse> responses = invoiceMapper.fromInvoiceEntityListToResponseList(listOfInvoice);
        return responses;
    }

    @Override
    public InvoiceEntity createInvoice(@Valid CreateInvoiceRequest request) {
        System.out.println(invoiceLimit);
        double newTotalAmount = totalInvoiceAmount + request.getAmount();
        InvoiceEntity entity = invoiceMapper.fromRequestToInvoiceEntity(request);
        if (request.getEmployeeId() == 0 || request.getInvoiceNo().isEmpty() || request.getProductName().isEmpty()) {
            throw new MethodArgumentNotValidException("Faturada boş alanlar mevcut");
        } else if (newTotalAmount > invoiceLimit) {
            throw new InvoiceLimitException("Limit aşıldı");
        }
        //InvoiceEntity entity = invoiceMapper.fromRequestToInvoiceEntity(request);
        invoiceRepository.saveAndFlush(entity);

        totalInvoiceAmount = newTotalAmount;
        return entity;
    }

    @Override
    public Boolean deleteInvoice(int id) {
        Optional<InvoiceEntity> invoiceEntity = invoiceRepository.findById(id);
        if (invoiceEntity.isPresent()) {
            invoiceRepository.deleteById(id);
            return true;
        } else {
            throw new InvoiceNotNullException("Invoice Id not found");
        }
    }

}

