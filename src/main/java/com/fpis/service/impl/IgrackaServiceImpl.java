/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.service.impl;

import com.fpis.domain.Igracka;
import com.fpis.repository.IgrackaRepository;
import com.fpis.service.IgrackaService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
@Transactional

public class IgrackaServiceImpl implements IgrackaService {

    @Autowired
    IgrackaRepository igrackaRepository;

    @Override
    public Igracka saveOrUpdate(Igracka igracka) {
        return igrackaRepository.save(igracka);
    }

    @Override
    public void delete(int id) {
        igrackaRepository.deleteById(id);
    }

    @Override
    public Igracka findById(int id) {
        Optional<Igracka> igracka = igrackaRepository.findById(id);
        if (igracka.isPresent()) {
            return igracka.get();
        }
        return null;
    }

    @Override
    public List<Igracka> findAll() {
        return igrackaRepository.findAll();
    }

}
