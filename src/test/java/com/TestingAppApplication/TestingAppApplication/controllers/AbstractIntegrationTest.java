package com.TestingAppApplication.TestingAppApplication.controllers;

import com.TestingAppApplication.TestingAppApplication.TestContainerConfiguration;
import com.TestingAppApplication.TestingAppApplication.dto.EmployeeDto;
import com.TestingAppApplication.TestingAppApplication.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

//This file is actually JavaCOCO report which is Java code coverage report
@AutoConfigureWebTestClient(timeout = "100000")
@Import(TestContainerConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //as this is integration test so this is being used
public class AbstractIntegrationTest {
    @Autowired
    WebTestClient webTestClient;

    Employee testEmployee = Employee.builder()
            //.id(1L)
            .email("ritika@gmail.com")
                .name("Ritika")
                .salary(200L)
                .build();
    EmployeeDto testEmployeeDto = EmployeeDto.builder()
            //.id(1L)
            .email("ritika@gmail.com")
                .name("Ritika")
                .salary(200L)
                .build();
}
