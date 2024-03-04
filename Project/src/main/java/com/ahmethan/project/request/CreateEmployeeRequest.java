package com.ahmethan.project.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.StringUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {
    private String firstName;
    private String lastName;
    private String email;


}

