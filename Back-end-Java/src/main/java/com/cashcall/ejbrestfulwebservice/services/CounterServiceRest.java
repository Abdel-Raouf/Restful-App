/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashcall.ejbrestfulwebservice.services;

import com.cashcall.ejbrestfulwebservice.HibernateUtil;
import com.cashcall.ejbrestfulwebservice.CounterBeanLocal;
import com.cashcall.ejbrestfulwebservice.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException; 
import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;





/**
 *
 * @author abdelraouf
 */
//defining the pass to the service 
@Path("/CounterServiceRest")
@Produces(MediaType.APPLICATION_JSON)
public class CounterServiceRest {
    
    
    /**
     *
     * @param id
     * @param name
     * @param address
     * @param salary
     * @return
     */
//  restful web service annotations to define the method behaviour.
    @POST
    @Path("/insertCustomer")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)

//    using rest annotations (@FormParam) to map to each parameter.
    public String insertCustomer(@FormParam("address") String address,@FormParam("id") Integer id,@FormParam("name") String name,@FormParam("salary") Double salary ) {
        
//        Connection c = null;
//        PreparedStatement preparedStatement = null;
//        String insertTableSQL = "INSERT INTO COMPANY"
//                + "(ID, NAME, ADDRESS, SALARY) "
//                + "VALUES (?,?,?,?)";
//        try {
//            Class.forName("org.postgresql.Driver");
//            c = DriverManager
//                    .getConnection("jdbc:postgresql://localhost:5432/mydb",
//                            "postgres", "homelinuxyxd123");
//            c.setAutoCommit(false);
//             
//            System.out.println("Opened database successfully");
//
//            preparedStatement = c.prepareStatement(insertTableSQL);
//
//            preparedStatement.setInt(1, id);
//            preparedStatement.setString(2, name);
//            preparedStatement.setString(3, address);
//            preparedStatement.setDouble(4, salary);
//
//            preparedStatement.executeUpdate();
//            c.commit();
//            preparedStatement.close();
//            c.close();
//            System.out.println("Record is intserted into company table");
//
//        } catch (Exception e) {
//           System.out.println(e);
//           e.printStackTrace();
//            return "-1";
//        }
//        return "0";

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        
        Customer employee = new Customer();
        
        employee.setId(id);
        employee.setName(name);
        employee.setAddress(address);
        employee.setSalary(salary);
        try {
            tx = session.beginTransaction();
            session.persist(employee);
            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
            return "-1";
        }

        return "0";
    }

    
    @GET
    @Path("/getAllCustomer")
    @Produces(MediaType.APPLICATION_JSON)

    public List<Customer> getAllCustomer() throws ClassNotFoundException, SQLException {
//        Class.forName("org.postgresql.Driver");
//        Connection c = DriverManager
//                .getConnection("jdbc:postgresql://localhost:5432/mydb",
//                        "postgres", "homelinuxyxd123");
//        c.setAutoCommit(false);
//        System.out.println("Opened database successfully");
//        Statement stm;
//        stm = c.createStatement();
//        String sql = "Select * From COMPANY";
//        ResultSet rst;
//        rst = stm.executeQuery(sql);
//        ArrayList<Customer> customerList = new ArrayList<>();
//        while (rst.next()) {
//            Customer customer = new Customer(rst.getInt("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
//            customerList.add(customer);
//        }
//        System.out.println("Opened database successfully");
//        rst.close();
//        stm.close();
//        c.close();
//        
//        
//        return customerList;


            
//          using hibernate as a middle-ware using HQL to map to SQL under the hood.
            List<Customer> customerList = new ArrayList<Customer>();
            Transaction tx = null;
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            try {
                tx = session.beginTransaction();
                Query query = session.createQuery("from Customer");
                customerList = (List<Customer>) query.list() ;
                tx.commit();                 
                 
            } catch (Exception e) {
                e.printStackTrace();  
            }
            
            return customerList;

    }

    
}
