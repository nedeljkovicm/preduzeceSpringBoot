/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.service;

import com.fpis.domain.Igracka;
import java.util.List;


/**
 *
 * @author User
 */
public interface IgrackaService {
    public Igracka saveOrUpdate(Igracka igracka);
    public void delete(int id);
    public Igracka findById(int id);
    public List<Igracka> findAll();
    
}
