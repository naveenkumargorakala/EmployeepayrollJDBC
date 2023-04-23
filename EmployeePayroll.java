package com.bridgelabz;

import java.sql.*;


public class EmployeePayroll {
    public static void main(String[] args) throws SQLException {


        String dbUrl = "jdbc:mysql://localhost:3306/payroll_service";
        String user = "root";
        String pass = "825131@Nh";

//        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbUrl, user, pass);
        Statement stmt = conn.createStatement();

//        ResultSet resultSet = stmt.executeQuery("select * from employee ");
//
//        System.out.println("Created table Successfully...!");


//        while (resultSet.next()) {
//            // Retrieve by column name
//            System.out.print("ID: " + resultSet.getInt("emp_id"));
//            System.out.print(", Name: " + resultSet.getString("emp_name"));
//            System.out.print(", Salary: " + resultSet.getDouble("salary"));
//            System.out.print(", Date: " + resultSet.getDate("start_date"));
//            System.out.println(", Email: "+ resultSet.getString("emp_email"));
//            System.out.println();
//
//
//        }

//        stmt.executeUpdate("create table employee_payroll( id int, name varchar(20),salary double,Basepay double,TaxablePay double,IncomeTax double, NetPay double,gender varchar(10))");
//        System.out.println("Employee_payroll is Created");
//        stmt.executeUpdate("insert into employee_payroll values(1,'Teresa',50000,100000,10000,20000,70000,'F')");
//        stmt.executeUpdate("insert into employee_payroll values(2,'Rutik',70000,250000,15000,25000,210000,'M')");
//        stmt.executeUpdate("insert into employee_payroll values(3,'Santhu',65000,400000,40000,80000,280000,'M')");
//        stmt.executeUpdate("insert into employee_payroll values(4,'Neeta',60000,300000,20000,30000,250000,'F')");

        ResultSet resultSet1=stmt.executeQuery("select * from employee_payroll");
        while(resultSet1.next()){
            System.out.print("Id: "+resultSet1.getInt("id"));
            System.out.print(", name: "+resultSet1.getString("name"));
            System.out.print(", Salary: "+resultSet1.getDouble("salary"));
            System.out.print(", Basepay: "+resultSet1.getDouble("Basepay"));
            System.out.println();
        }
        // Update teresa basepay to 300000;
        stmt.executeUpdate("update employee_payroll set Basepay=300000 where name='Teresa'");
//        System.out.println("Update Basepay of Teresa...");
        System.out.println("Record Added...!");
        conn.close();
    }
}
