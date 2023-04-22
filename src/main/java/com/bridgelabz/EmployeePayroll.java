package com.bridgelabz;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class EmployeePayroll {
    public static void main(String[] args) {


        String dbUrl = "jdbc:mysql://localhost:3306/payroll_service";
        String user = "root";
        String pass = "825131@Nh";

        Connection conn;
//        try {
//            String s = "com.mysql.jdbc.Driver";
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver Loaded");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        listDrivers();
        try {
            conn = DriverManager.getConnection(dbUrl, user, pass);
            System.out.println("connection successfullyy..." + conn);
        } catch (SQLException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
    }

    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println("  " + driverClass.getClass().getName());
        }
    }
}
