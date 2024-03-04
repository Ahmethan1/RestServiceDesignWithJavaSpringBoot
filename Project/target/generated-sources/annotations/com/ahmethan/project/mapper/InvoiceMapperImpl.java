package com.ahmethan.project.mapper;

import com.ahmethan.project.dto.EmployeeDto;
import com.ahmethan.project.entities.EmployeeEntity;
import com.ahmethan.project.entities.InvoiceEntity;
import com.ahmethan.project.request.CreateInvoiceRequest;
import com.ahmethan.project.response.InvoiceWithEmployeeResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-03T20:15:55+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class InvoiceMapperImpl implements InvoiceMapper {

    @Override
    public InvoiceEntity fromRequestToInvoiceEntity(CreateInvoiceRequest request) {
        if ( request == null ) {
            return null;
        }

        InvoiceEntity invoiceEntity = new InvoiceEntity();

        invoiceEntity.setEmployeeEntity( createInvoiceRequestToEmployeeEntity( request ) );
        invoiceEntity.setProductName( request.getProductName() );
        invoiceEntity.setAmount( request.getAmount() );
        invoiceEntity.setInvoiceNo( request.getInvoiceNo() );

        return invoiceEntity;
    }

    @Override
    public List<InvoiceWithEmployeeResponse> fromInvoiceEntityListToResponseList(List<InvoiceEntity> invoiceEntities) {
        if ( invoiceEntities == null ) {
            return null;
        }

        List<InvoiceWithEmployeeResponse> list = new ArrayList<InvoiceWithEmployeeResponse>( invoiceEntities.size() );
        for ( InvoiceEntity invoiceEntity : invoiceEntities ) {
            list.add( fromInvoiceEntityToResponse( invoiceEntity ) );
        }

        return list;
    }

    @Override
    public InvoiceWithEmployeeResponse fromInvoiceEntityToResponse(InvoiceEntity invoiceEntity) {
        if ( invoiceEntity == null ) {
            return null;
        }

        InvoiceWithEmployeeResponse invoiceWithEmployeeResponse = new InvoiceWithEmployeeResponse();

        invoiceWithEmployeeResponse.setEmployeeDto( fromEmployeeEntityToEmployeeDto( invoiceEntity.getEmployeeEntity() ) );
        invoiceWithEmployeeResponse.setProductName( invoiceEntity.getProductName() );
        invoiceWithEmployeeResponse.setAmount( invoiceEntity.getAmount() );
        invoiceWithEmployeeResponse.setInvoiceNo( invoiceEntity.getInvoiceNo() );

        return invoiceWithEmployeeResponse;
    }

    @Override
    public EmployeeDto fromEmployeeEntityToEmployeeDto(EmployeeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId( entity.getId() );
        employeeDto.setFirstName( entity.getFirstName() );
        employeeDto.setLastName( entity.getLastName() );
        employeeDto.setEmail( entity.getEmail() );

        return employeeDto;
    }

    protected EmployeeEntity createInvoiceRequestToEmployeeEntity(CreateInvoiceRequest createInvoiceRequest) {
        if ( createInvoiceRequest == null ) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setId( createInvoiceRequest.getEmployeeId() );

        return employeeEntity;
    }
}
