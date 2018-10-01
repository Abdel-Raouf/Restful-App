/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashcall.ejbrestfulwebservice;

import javax.ejb.Singleton;
import javax.ejb.Lock;
import javax.ejb.LockType;

/**
 *
 * @author abdelraouf
 */
@Singleton
public class CounterBean implements CounterBeanLocal {
    
    private int hits = 1;
    
    @Lock(LockType.READ)
    public int getHits() {
        return hits++;
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
