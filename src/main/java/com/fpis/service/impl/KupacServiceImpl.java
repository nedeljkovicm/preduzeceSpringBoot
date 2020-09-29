/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.service.impl;

import com.fpis.domain.Kupac;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fpis.repository.KupacRepository;
import com.fpis.service.KupacService;

/**
 *
 * @author User
 */
@Service
@Transactional

public class KupacServiceImpl implements KupacService {

    @Autowired
    KupacRepository kupacRepository;

    @Override
    public Kupac saveOrUpdate(Kupac kupac) {
        return kupacRepository.save(kupac);
    }

    @Override
    public void delete(int id) {
        kupacRepository.deleteById(id);
    }

    @Override
    public Kupac findById(int id) {
        Optional<Kupac> kupac = kupacRepository.findById(id);
        if (kupac.isPresent()) {
            return kupac.get();
        }
        return null;
    }

    @Override
    public List<Kupac> findAll() {
        return kupacRepository.findAll();
    }

}
