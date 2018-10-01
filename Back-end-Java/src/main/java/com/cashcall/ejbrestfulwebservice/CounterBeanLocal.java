/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashcall.ejbrestfulwebservice;

import javax.ejb.Local;

/**
 *
 * @author abdelraouf
 */
@Local
public interface CounterBeanLocal {

public int getHits();    
}
