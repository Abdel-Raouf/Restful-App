/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashcall.ejbrestfulwebservice;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author abdelraouf
 */
@Entity
@Table(name = "COMPANY")
public class Customer implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "salary")
    private Double salary;
    
    @Column(name = "address")
    private String address;
    

    public Customer() {
        
    }
    
    /**
     *
     * @param id
     * @param name
     * @param address
     * @param salary
     */
    public Customer(Integer id, String name, String address, Double salary) {
        this.id = id;
        this.name = name;

        this.address = address;
        
        
        this.salary = salary;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name +", salary=" + salary + ", address=" + address + '}';
    }

    
    
    

}
