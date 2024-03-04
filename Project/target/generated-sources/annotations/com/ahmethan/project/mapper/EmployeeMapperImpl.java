package com.ahmethan.project.mapper;

import com.ahmethan.project.dto.EmployeeDto;
import com.ahmethan.project.entities.EmployeeEntity;
import com.ahmethan.project.request.CreateEmployeeRequest;
import com.ahmethan.project.response.EmployeeResponse;
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
public class EmployeeMapperImpl implements EmployeeMapper {

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

    @Override
    public List<EmployeeResponse> fromEmployeeEntityListToResponseList(List<EmployeeEntity> employeeEntities) {
        if ( employeeEntities == null ) {
            return null;
        }

        List<EmployeeResponse> list = new ArrayList<EmployeeResponse>( employeeEntities.size() );
        for ( EmployeeEntity employeeEntity : employeeEntities ) {
            list.add( fromEmployeeEntityToEmployeeResponse( employeeEntity ) );
        }

        return list;
    }

    @Override
    public EmployeeEntity fromRequestToEmployeeEntity(CreateEmployeeRequest request) {
        if ( request == null ) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setFirstName( request.getFirstName() );
        employeeEntity.setLastName( request.getLastName() );
        employeeEntity.setEmail( request.getEmail() );

        return employeeEntity;
    }

    @Override
    public EmployeeResponse fromEmployeeEntityToEmployeeResponse(EmployeeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeResponse employeeResponse = new EmployeeResponse();

        employeeResponse.setFirstName( entity.getFirstName() );
        employeeResponse.setLastName( entity.getLastName() );
        employeeResponse.setEmail( entity.getEmail() );

        return employeeResponse;
    }
}
