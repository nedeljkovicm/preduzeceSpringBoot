/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.service.impl;

import com.fpis.domain.Narudzbenica;
import com.fpis.domain.StavkaNarudzbenice;
import com.fpis.domain.StavkaNarudzbeniceId;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fpis.repository.NarudzbenicaRepository;
import com.fpis.repository.StavkaNarudzbeniceRepository;
import com.fpis.service.NarudzbenicaService;

/**
 *
 * @author User
 */
@Service
@Transactional

public class NarudzbenicaServiceImpl implements NarudzbenicaService {

    @Autowired
    NarudzbenicaRepository narudzbenicaRepository;
    @Autowired
    StavkaNarudzbeniceRepository stavkaNarudzbeniceRepository;

    @Override
    public Narudzbenica saveOrUpdate(Narudzbenica narudzbenica) {
        Narudzbenica n = findById(narudzbenica.getNarudzbenicaId());
       
        if (n != null) {
              
              stavkaNarudzbeniceRepository.deleteByNarudzbenicaNarudzbenicaId(n.getNarudzbenicaId());
              
            if (narudzbenica.getStavkeNarudzbenice() != null) {
                
            for (StavkaNarudzbenice stavkaNarudzbenice : narudzbenica.getStavkeNarudzbenice()) {
                stavkaNarudzbenice.setNarudzbenica(new Narudzbenica(narudzbenica.getNarudzbenicaId(),null,0,null,null,null));
                System.out.println(stavkaNarudzbenice.getStavkaNarudzbeniceId());
                
            }
            stavkaNarudzbeniceRepository.saveAll(narudzbenica.getStavkeNarudzbenice());
        }   
            narudzbenicaRepository.save(narudzbenica);
            return narudzbenica;
        }
        else{
           narudzbenica = narudzbenicaRepository.save(narudzbenica);
            System.out.println(narudzbenica.getStavkeNarudzbenice().size());
        if (narudzbenica.getStavkeNarudzbenice() != null) {
            
            for (StavkaNarudzbenice stavkaNarudzbenice : narudzbenica.getStavkeNarudzbenice()) {
                stavkaNarudzbenice.setNarudzbenica(new Narudzbenica(narudzbenica.getNarudzbenicaId(), null, 0, null,null,null));
                System.out.println(stavkaNarudzbenice.getStavkaNarudzbeniceId());
                
            }
            stavkaNarudzbeniceRepository.saveAll(narudzbenica.getStavkeNarudzbenice());
        }

        return narudzbenica;
        }
    }

    @Override
    public void delete(int id) {
        narudzbenicaRepository.deleteById(id);
    }

    @Override
    public Narudzbenica findById(int id) {
        Optional<Narudzbenica> narudzbenica = narudzbenicaRepository.findById(id);

        if (narudzbenica.isPresent()) {
            return narudzbenica.get();
        }

        return null;
    }

    @Override
    public List<Narudzbenica> findAll() {
        return narudzbenicaRepository.findAll();
    }

}
