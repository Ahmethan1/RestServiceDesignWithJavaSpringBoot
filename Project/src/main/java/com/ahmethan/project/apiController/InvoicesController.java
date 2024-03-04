package com.ahmethan.project.apiController;

import com.ahmethan.project.dto.InvoiceDto;
import com.ahmethan.project.entities.InvoiceEntity;
import com.ahmethan.project.repository.InvoiceRepository;
import com.ahmethan.project.request.CreateInvoiceRequest;
import com.ahmethan.project.response.InvoiceWithEmployeeResponse;
import com.ahmethan.project.service.InvoiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoicesController {

    private final InvoiceService invoiceService;

    @GetMapping("/AllInvoices")
    public ResponseEntity<List<InvoiceWithEmployeeResponse>> getAll(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        List<InvoiceWithEmployeeResponse> invoiceDtos = invoiceService.getAll(pageNo, pageSize);
        return ResponseEntity.ok(invoiceDtos);
    }

    @PostMapping("/InvoiceCreate")
    public ResponseEntity<InvoiceEntity> createInvoice(@Valid @RequestBody CreateInvoiceRequest request) {
        InvoiceEntity result = invoiceService.createInvoice(request);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteInvoice(@PathVariable("id") int id) {
        Boolean a = invoiceService.deleteInvoice(id);

        return ResponseEntity.ok(a);
    }

}
