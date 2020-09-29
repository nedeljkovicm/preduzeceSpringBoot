/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.service;

import com.fpis.domain.Kupac;
import java.util.List;


/**
 *
 * @author User
 */
public interface KupacService {
    public Kupac saveOrUpdate(Kupac kupac);
    public void delete(int id);
    public Kupac findById(int id);
    public List<Kupac> findAll();
    
}
