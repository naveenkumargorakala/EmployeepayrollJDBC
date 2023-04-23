package com.bridgelabz;

import java.sql.*;
import java.util.Enumeration;

public class EmployeePayroll {
    public static void main(String[] args) throws SQLException, NullPointerException {


        String dbUrl = "jdbc:mysql://localhost:3306/payroll_service";
        String user = "root";
        String pass = "825131@Nh";

//        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbUrl, user, pass);
        Statement stmt = conn.createStatement();


//        stmt.executeUpdate("create table employee_payroll( id int, name varchar(20),salary double,Basepay double,TaxablePay double,IncomeTax double, NetPay double,gender varchar(10))");
//        System.out.println("Employee_payroll is Created");
//        stmt.executeUpdate("insert into employee_payroll values(1,'Teresa',50000,100000,10000,20000,70000,'F')");
//        stmt.executeUpdate("insert into employee_payroll values(2,'Rutik',70000,250000,15000,25000,210000,'M')");
//        stmt.executeUpdate("insert into employee_payroll values(3,'Santhu',65000,400000,40000,80000,280000,'M')");
//        stmt.executeUpdate("insert into employee_payroll values(4,'Neeta',60000,300000,20000,30000,250000,'F')");


        // Update teresa basepay to 300000;
        PreparedStatement statement = null;

//        try {
//            conn.prepareStatement("update employee_payroll set Basepay=300000 where name='Teresa'");
//            System.out.println("Update Basepay of Teresa...");
//            statement=conn.prepareStatement("select * from employee_payroll where name='Teresa'");
//            System.out.println("retreive from table by use name...");
//              statement=conn.prepareStatement("select * from employee_payroll where start_date between '2021-12-23' and '2022-12-30'");
//            statement= conn.prepareStatement("select SUM(salary) from employee_payroll");
            ResultSet resultSet=stmt.executeQuery("select SUM(salary) from employee_payroll where gender='F' group by gender" );
          int sum=0;
//        System.out.println(resultSet.next());
              while(resultSet.next()) {
                  double result = resultSet.getDouble(1);
              sum+=result;
              }
        System.out.println("Sum is: "+sum);

        ResultSet resultSet1= stmt.executeQuery("select Count(salary) from employee_payroll where gender='M' group by gender");
        int count=0;
        while(resultSet1.next()) {
            double result = resultSet1.getDouble(1);
            System.out.println("Count:  "+result);
        }
        ResultSet resultSet2= stmt.executeQuery("select AVG(salary) from employee_payroll where gender = 'M' group by gender");
        while(resultSet2.next()){
            double result = resultSet2.getDouble(1);
            System.out.println("Average:  "+result);
        }

        ResultSet resultSet3=stmt.executeQuery("select Min(salary) from employee_payroll" );
        while(resultSet3.next()){
            double result = resultSet3.getDouble(1);
            System.out.println("Min of Salary: "+result);
        }

        ResultSet resultSet4=stmt.executeQuery("select Max(salary) from employee_payroll" );
        while(resultSet4.next()){
            double result = resultSet4.getDouble(1);
            System.out.println("Max of Salary: "+result);
        }

        //        ResultSet resultSet3= stmt.executeQuery("select MIN(salary) from employee_payroll where gender = 'F' group by gender");
//        ResultSet resultSet4= stmt.executeQuery("select Max(salary) from employee_payroll where gender = 'F' group by gender");

//
//        int max
//        while(resultSet1.next()) {
//            double result = resultSet.getDouble(1);
//            int max+=result;
//        }
//        System.out.println("Sum is: "+max);

//            while(resultSet.next()) {
//                System.out.print("Id: " + resultSet.getInt("id"));
//                System.out.print(", name: " + resultSet.getString("name"));
//                System.out.print(", Salary: " + resultSet.getDouble("salary"));
//                System.out.print(", Basepay: " + resultSet.getDouble("Basepay"));
//                System.out.println(", StartDate: "+ resultSet.getDate("start_date"));
//                System.out.println();
//            }
//        }
//        catch(NullPointerException e)
//        {
//            e.fillInStackTrace();
//        }
//

//        ResultSet resultSet1=stmt.executeQuery("select * from employee_payroll");
//        while(resultSet1.next()){
//            System.out.print("Id: "+resultSet1.getInt("id"));
//            System.out.print(", name: "+resultSet1.getString("name"));
//            System.out.print(", Salary: "+resultSet1.getDouble("salary"));
//            System.out.print(", Basepay: "+resultSet1.getDouble("Basepay"));
//            System.out.println(", Start Date"+resultSet1.getDate("start_date"));
//            System.out.println();
//        }
//        System.out.println("Record Added...!");
        conn.close();
    }
}