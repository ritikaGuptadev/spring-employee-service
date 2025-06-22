package com.TestingAppApplication.TestingAppApplication.repositories;

import com.TestingAppApplication.TestingAppApplication.TestContainerConfiguration;
import com.TestingAppApplication.TestingAppApplication.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static jdk.dynalink.linker.support.Guards.isNotNull;
import static org.apache.logging.log4j.util.Strings.isNotEmpty;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Import(TestContainerConfiguration.class)
@DataJpaTest //For making this class a bean added this annotation
//but this above annotation take too long to run
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    void setup() {
        employee = Employee.builder()
                //.id(1L)
                .name("Ritika")
                .email("ritika@gmail.com")
                .salary(100L)
                .build();
    }

    @Test
    void testFindByEmail_whenEmailIsPresent_thenReturnEmployee() {
        //Arrange or Given
        employeeRepository.save(employee);

        //Act or When
        List<Employee> employeeList = employeeRepository.findByEmail(employee.getEmail());


        //Assert or Then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isNotEmpty();
        assertThat(employeeList.get(0).getEmail()).isEqualTo(employee.getEmail());
    }

    @Test
    void testFindByEmail_whenEmailIsNotFound_thenReturnEmptyEmployeeList() {
        //Given
        String email = "notPresent.123@gmail.com";

        //When
        List<Employee> employeeList = employeeRepository.findByEmail(email);

        //Then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isEmpty();
    }
}