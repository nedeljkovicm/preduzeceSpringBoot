/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.controller;

import com.fpis.domain.Igracka;
import com.fpis.dto.IgrackaDto;
import com.fpis.service.IgrackaService;
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
@RequestMapping("/igracka/*")
@CrossOrigin
//@CrossOrigin(origins = "http://localhost:4200")
public class IgrackaController {

    @Autowired
    IgrackaService igrackaService;
    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value="get/all", method = RequestMethod.GET)
    public List<IgrackaDto> getAll() {
        List<Igracka> igracke = igrackaService.findAll();
        return igracke.stream()
                .map(igracka -> modelMapper.map(igracka, IgrackaDto.class))
                .collect(Collectors.toList());
    }

    @RequestMapping(value="get/{id}", method = RequestMethod.GET)
    public IgrackaDto getById(@PathVariable int id) {
        Igracka igracka = igrackaService.findById(id);
        if (igracka!=null) {
            return modelMapper.map(igracka, IgrackaDto.class);
        }
        return null;
    }

    @RequestMapping(value="save", method = RequestMethod.POST)
    public IgrackaDto save(@RequestBody IgrackaDto igrackaDto) {
        System.out.println(igrackaDto);
        Igracka igracka = modelMapper.map(igrackaDto, Igracka.class);
        igracka = igrackaService.saveOrUpdate(igracka);
        return modelMapper.map(igracka, IgrackaDto.class);
    }

    @RequestMapping(value="update", method= RequestMethod.PUT)
    public IgrackaDto update(@RequestBody IgrackaDto igrackaDto) {
        Igracka igracka = modelMapper.map(igrackaDto, Igracka.class);
        igracka = igrackaService.saveOrUpdate(igracka);
        return modelMapper.map(igracka, IgrackaDto.class);
    }

    @RequestMapping(value="delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        igrackaService.delete(id);

    }
}
