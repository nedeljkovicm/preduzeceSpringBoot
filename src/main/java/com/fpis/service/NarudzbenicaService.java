/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.service;


import com.fpis.domain.Narudzbenica;
import java.util.List;


/**
 *
 * @author User
 */
public interface NarudzbenicaService {
    public Narudzbenica saveOrUpdate(Narudzbenica narudzbenica);
    public void delete(int id);
    public Narudzbenica findById(int id);
    public List<Narudzbenica> findAll();
}
