package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeePayrollTest {
    EmployeePayroll employeePayroll = new EmployeePayroll();
    @Test
    void givenEmployeeeAddedShouldReturnSyncData(){
        String actualValue=employeePayroll.addEmployee();
        Assertions.assertEquals("insert into employee_payroll values(5,'Sai',76000,900000,200000,10000,690000,'M')",actualValue);
    }
}
