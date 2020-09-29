/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.service;


import com.fpis.domain.Katalog;
import java.util.List;


/**
 *
 * @author User
 */
public interface KatalogService {
    public Katalog saveOrUpdate(Katalog katalog);
    public void delete(int id);
    public Katalog findById(int id);
    public List<Katalog> findAll();
}
