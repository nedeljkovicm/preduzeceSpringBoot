/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.service.impl;

import com.fpis.domain.Katalog;
import com.fpis.domain.StavkaKataloga;
import com.fpis.domain.StavkaKatalogaId;
import com.fpis.repository.KatalogRepository;
import com.fpis.repository.StavkaKatalogaRepository;
import com.fpis.service.KatalogService;
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

public class KatalogServiceImpl implements KatalogService {

    @Autowired
    KatalogRepository katalogRepository;
    @Autowired
    StavkaKatalogaRepository stavkaKatalogaRepository;

    @Override
    public Katalog saveOrUpdate(Katalog katalog) {
        Katalog k = findById(katalog.getKatalogId());
       
        if (k != null) {
              
              stavkaKatalogaRepository.deleteByKatalogKatalogId(k.getKatalogId());
              
            if (katalog.getStavkeKataloga() != null) {
                
            for (StavkaKataloga stavkaKataloga : katalog.getStavkeKataloga()) {
                stavkaKataloga.setKatalog(new Katalog(katalog.getKatalogId(), null, null, null,null));
                System.out.println(stavkaKataloga.getStavkaKatalogaId());
                
            }
            stavkaKatalogaRepository.saveAll(katalog.getStavkeKataloga());
        }   
            katalogRepository.save(katalog);
            return katalog;
        }
        else{
           katalog = katalogRepository.save(katalog);
            System.out.println(katalog.getStavkeKataloga().size());
        if (katalog.getStavkeKataloga() != null) {
            
            for (StavkaKataloga stavkaKataloga : katalog.getStavkeKataloga()) {
                stavkaKataloga.setKatalog(new Katalog(katalog.getKatalogId(), null, null, null,null));
                System.out.println(stavkaKataloga.getStavkaKatalogaId());
                
            }
            stavkaKatalogaRepository.saveAll(katalog.getStavkeKataloga());
        }

        return katalog;
        }
    }

    @Override
    public void delete(int id) {
        katalogRepository.deleteById(id);
    }

    @Override
    public Katalog findById(int id) {
        Optional<Katalog> katalog = katalogRepository.findById(id);

        if (katalog.isPresent()) {
            return katalog.get();
        }

        return null;
    }

    @Override
    public List<Katalog> findAll() {
        return katalogRepository.findAll();
    }

}
