package com.cashcall.ejbrestfulwebservice.services;
import com.cashcall.ejbrestfulwebservice.Customer;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDBAccessMain {
   public static void main(String args[]) throws ClassNotFoundException, SQLException {
//       createTable();
       insertFunc();
       selectFunc();
      ArrayList <Customer> custList= getAllCustomer();
        for (Customer customer: custList) {
            System.out.println(customer);
       }
        
        
        
        Customer c = new Customer();
        c.setId(100);
        c.setName("Abdelraouf");
        
        c.setAddress("333 St. jhjhjh");
        c.setSalary(10000.00);
        insertCustomer(c);
      
   }
   public static void createTable(){
       Connection c = null;
       Statement stmt = null;
       try{
           Class.forName("org.postgresql.Driver");
           c = DriverManager
                   .getConnection("jdbc:postgresql://localhost:5432/mydb", 
                           "postgres", "homelinuxyxd123");
           System.out.println("Opened database successfully");
           
           stmt = c.createStatement();
           String sql = "CREATE TABLE COMPANY" +
                   "(ID SERIAL PRIMARY KEY   NOT NULL, " +
                   "NAME              TEXT  NOT NULL, " +
                   "ADDRESS           CHAR(50), " +
                   "SALARY            REAL)";
           stmt.executeUpdate(sql);
           stmt.close();
           c.close();
       }catch (Exception e) {
           System.err.println( e.getClass().getName()+ ": "+ e.getMessage() );
           System.exit(0);
       }
       System.out.println("Table created successfully");
   }
   
   public static void selectFunc(){
        Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/mydb",
            "postgres", "homelinuxyxd123");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
         while ( rs.next() ) {
            int id = rs.getInt("id");
            String  name = rs.getString("name");
            int age  = rs.getInt("age");
            String  address = rs.getString("address");
            float salary = rs.getFloat("salary");
            System.out.println( "ID = " + id );
            System.out.println( "NAME = " + name );
            System.out.println( "AGE = " + age );
            System.out.println( "ADDRESS = " + address );
            System.out.println( "SALARY = " + salary );
            System.out.println();
         }
         rs.close();
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Operation done successfully");

   }
   
   public static void insertFunc(){
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/mydb",
            "postgres", "homelinuxyxd123");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO COMPANY (NAME,ADDRESS,SALARY) "
            + "VALUES ('Paul', 'California', 20000.00 );";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO COMPANY (NAME,ADDRESS,SALARY) "
            + "VALUES ('Allen','Texas', 15000.00 );";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO COMPANY (NAME,ADDRESS,SALARY) "
            + "VALUES ('Teddy','Norway', 20000.00 );";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO COMPANY (NAME,ADDRESS,SALARY) "
            + "VALUES ('Mark','Rich-Mond ', 65000.00 );";
         stmt.executeUpdate(sql);

         stmt.close();
         c.commit();
         c.close();
      } catch (Exception e) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }
   
   public static ArrayList<Customer> getAllCustomer() throws ClassNotFoundException, SQLException {
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
    return customerList;
}
   
   public static void insertCustomer(Customer cust){
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
         
         System.out.println("Record is intserted into company table");

       } catch(Exception e) {
           System.out.println(e);
       }
       
   }
}