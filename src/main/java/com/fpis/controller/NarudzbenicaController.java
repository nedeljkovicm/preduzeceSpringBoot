/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fpis.domain.Narudzbenica;
import com.fpis.domain.StavkaNarudzbenice;
import com.fpis.dto.NarudzbenicaDto;
import com.fpis.dto.StavkaNarudzbeniceDto;
import com.fpis.domain.StavkaNarudzbeniceId;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fpis.service.NarudzbenicaService;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/narudzbenica/*")
@CrossOrigin
//@CrossOrigin(origins = "http://localhost:4200")
@JsonView
public class NarudzbenicaController {

    @Autowired
    NarudzbenicaService narudzbenicaService;
    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "get/all", method = RequestMethod.GET)
    public List<NarudzbenicaDto> getAll() {
        List<Narudzbenica> narudzbenice = narudzbenicaService.findAll();
        return narudzbenice.stream()
                .map(narudzbenica -> modelMapper.map(narudzbenica, NarudzbenicaDto.class))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public NarudzbenicaDto getById(@PathVariable int id) {
        Narudzbenica narudzbenica = narudzbenicaService.findById(id);
        return modelMapper.map(narudzbenica, NarudzbenicaDto.class);

    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public NarudzbenicaDto save(@RequestBody NarudzbenicaDto narudzbenicaDto) {
        System.out.println(narudzbenicaDto);
        Narudzbenica narudzbenica = modelMapper.map(narudzbenicaDto, Narudzbenica.class);
        System.out.println(narudzbenica);

        for (StavkaNarudzbenice stavkaNarudzbenice : narudzbenica.getStavkeNarudzbenice()) {
            stavkaNarudzbenice.setStavkaNarudzbeniceId(new StavkaNarudzbeniceId(0, narudzbenicaDto.getStavkeNarudzbenice().get(narudzbenica.getStavkeNarudzbenice().indexOf(stavkaNarudzbenice)).getStavkaNarudzbeniceId().getRedniBroj()));
            
        }

        narudzbenica = narudzbenicaService.saveOrUpdate(narudzbenica);
        NarudzbenicaDto dto = mapiraj(narudzbenica);

        return dto;
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public NarudzbenicaDto update(@RequestBody NarudzbenicaDto narudzbenicaDto, @PathVariable int id) {
        Narudzbenica narudzbenica = modelMapper.map(narudzbenicaDto, Narudzbenica.class);
        System.out.println(narudzbenicaDto);
        System.out.println(narudzbenica);
                
          if (narudzbenica.getStavkeNarudzbenice() != null) {
            for (StavkaNarudzbenice stavkaNarudzbenice : narudzbenica.getStavkeNarudzbenice()) {
                stavkaNarudzbenice.setStavkaNarudzbeniceId(new StavkaNarudzbeniceId(id, narudzbenicaDto.getStavkeNarudzbenice().get(narudzbenica.getStavkeNarudzbenice().indexOf(stavkaNarudzbenice)).getStavkaNarudzbeniceId().getRedniBroj()));
                System.out.println(stavkaNarudzbenice.getStavkaNarudzbeniceId());
            }
        }

        narudzbenica = narudzbenicaService.saveOrUpdate(narudzbenica);
        NarudzbenicaDto dto = mapiraj(narudzbenica);

        return dto;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        narudzbenicaService.delete(id);

    }

    private NarudzbenicaDto mapiraj(Narudzbenica narudzbenica) {

        NarudzbenicaDto narudzbenicaDto = modelMapper.map(narudzbenica, NarudzbenicaDto.class);
        System.out.println(narudzbenicaDto);
        if (narudzbenica.getStavkeNarudzbenice() != null) {
            for (StavkaNarudzbeniceDto stavkaNarudzbeniceDto : narudzbenicaDto.getStavkeNarudzbenice()) {
                StavkaNarudzbeniceId redniBroj = narudzbenica.getStavkeNarudzbenice().get(narudzbenicaDto.getStavkeNarudzbenice()
                        .indexOf(stavkaNarudzbeniceDto)).getStavkaNarudzbeniceId();
                stavkaNarudzbeniceDto.setStavkaNarudzbeniceId(redniBroj);
                stavkaNarudzbeniceDto.setNarudzbenica(narudzbenicaDto);
            }
        }

        return narudzbenicaDto;
    }
}
