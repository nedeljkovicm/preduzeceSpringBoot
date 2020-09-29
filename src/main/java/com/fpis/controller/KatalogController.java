/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fpis.domain.Katalog;
import com.fpis.domain.StavkaKataloga;
import com.fpis.dto.KatalogDto;
import com.fpis.dto.StavkaKatalogaDto;
import com.fpis.service.KatalogService;
import com.fpis.domain.StavkaKatalogaId;
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

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/katalog/*")
@CrossOrigin
//@CrossOrigin(origins = "http://localhost:4200")
@JsonView
public class KatalogController {

    @Autowired
    KatalogService katalogService;
    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "get/all", method = RequestMethod.GET)
    public List<KatalogDto> getAll() {
        List<Katalog> katalozi = katalogService.findAll();
        return katalozi.stream()
                .map(katalog -> modelMapper.map(katalog, KatalogDto.class))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public KatalogDto getById(@PathVariable int id) {
        Katalog katalog = katalogService.findById(id);
        return modelMapper.map(katalog, KatalogDto.class);

    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public KatalogDto save(@RequestBody KatalogDto katalogDto) {
        System.out.println(katalogDto);
        Katalog katalog = modelMapper.map(katalogDto, Katalog.class);
        System.out.println(katalog);

        for (StavkaKataloga stavkaKataloga : katalog.getStavkeKataloga()) {
            stavkaKataloga.setStavkaKatalogaId(new StavkaKatalogaId(0, katalogDto.getStavkeKataloga().get(katalog.getStavkeKataloga().indexOf(stavkaKataloga)).getStavkaKatalogaId().getRedniBroj()));

        }

        katalog = katalogService.saveOrUpdate(katalog);
        KatalogDto dto = mapiraj(katalog);

        return dto;
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public KatalogDto update(@RequestBody KatalogDto katalogDto, @PathVariable int id) {
        Katalog katalog = modelMapper.map(katalogDto, Katalog.class);
        System.out.println(katalogDto);
        System.out.println(katalog);
                
          if (katalog.getStavkeKataloga() != null) {
            for (StavkaKataloga stavkaKataloga : katalog.getStavkeKataloga()) {
                stavkaKataloga.setStavkaKatalogaId(new StavkaKatalogaId(id, katalogDto.getStavkeKataloga().get(katalog.getStavkeKataloga().indexOf(stavkaKataloga)).getStavkaKatalogaId().getRedniBroj()));
                System.out.println(stavkaKataloga.getStavkaKatalogaId());
            }
        }

        katalog = katalogService.saveOrUpdate(katalog);
        KatalogDto dto = mapiraj(katalog);

        return dto;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        katalogService.delete(id);

    }

    private KatalogDto mapiraj(Katalog katalog) {

        KatalogDto katalogDto = modelMapper.map(katalog, KatalogDto.class);
        System.out.println(katalogDto);
        if (katalog.getStavkeKataloga() != null) {
            for (StavkaKatalogaDto stavkaKatalogaDto : katalogDto.getStavkeKataloga()) {
                StavkaKatalogaId redniBroj = katalog.getStavkeKataloga().get(katalogDto.getStavkeKataloga()
                        .indexOf(stavkaKatalogaDto)).getStavkaKatalogaId();
                stavkaKatalogaDto.setStavkaKatalogaId(redniBroj);
                stavkaKatalogaDto.setKatalog(katalogDto);
            }
        }

        return katalogDto;
    }
}
