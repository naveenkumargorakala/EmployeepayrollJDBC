package com.bridgelabz;

import java.sql.*;
import java.util.Enumeration;

public class EmployeePayroll {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        String dbUrl = "jdbc:mysql://localhost:3306/payroll_service";
        String user = "root";
        String pass = "825131@Nh";

//        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbUrl, user, pass);


        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from employee ");

        System.out.println("Created table Successfully...!");


        while (resultSet.next()) {
            // Retrieve by column name
            System.out.print("ID: " + resultSet.getInt("emp_id"));
            System.out.print(", Name: " + resultSet.getString("emp_name"));
            System.out.print(", Salary: " + resultSet.getDouble("salary"));
            System.out.print(", Date: " + resultSet.getDate("start_date"));
            System.out.println(", Email: "+ resultSet.getString("emp_email"));
            System.out.println();


        }
        conn.close();
    }
}
