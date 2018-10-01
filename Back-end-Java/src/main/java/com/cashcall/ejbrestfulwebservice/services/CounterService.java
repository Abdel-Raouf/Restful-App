/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashcall.ejbrestfulwebservice.services;

import com.cashcall.ejbrestfulwebservice.CounterBeanLocal;
import com.cashcall.ejbrestfulwebservice.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author abdelraouf
 */
@WebService(serviceName = "CounterService")
public class CounterService {

    @EJB
    private CounterBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "getHits")
    public int getHits() {
        return ejbRef.getHits();
    }

    @WebMethod(operationName = "insertCustomer")
    public int insertCustomer(Customer cust) {
        Connection c = null;
        PreparedStatement preparedStatement = null;
        String insertTableSQL = "INSERT INTO COMPANY"
                + "(ID, NAME, ADDRESS, SALARY) "
                + "VALUES (?,?,?,?)";
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/mydb",
                            "postgres", "homelinuxyxd123");
            c.setAutoCommit(false);

            System.out.println("Opened database successfully");

            preparedStatement = c.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, cust.getId());
            preparedStatement.setString(2, cust.getName());
            preparedStatement.setString(3, cust.getAddress());
            preparedStatement.setDouble(4, cust.getSalary());

            preparedStatement.executeUpdate();
            c.commit();
            preparedStatement.close();
            c.close();
            System.out.println("Record is intserted into company table");

        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
        return 0;
    }

    @WebMethod(operationName = "getAllCustomer")
    public ArrayList<Customer> getAllCustomer() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/mydb",
                        "postgres", "homelinuxyxd123");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");
        Statement stm;
        stm = c.createStatement();
        String sql = "Select * From COMPANY";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        ArrayList<Customer> customerList = new ArrayList<>();
        while (rst.next()) {
            Customer customer = new Customer(rst.getInt("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
            customerList.add(customer);
        }
        System.out.println("Opened database successfully");
        rst.close();
        stm.close();
        c.close();
        return customerList;
    }

}
