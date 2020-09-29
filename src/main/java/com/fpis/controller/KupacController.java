/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.controller;

import com.fpis.domain.Kupac;
import com.fpis.dto.KupacDto;
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
import com.fpis.service.KupacService;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/kupac/*")
@CrossOrigin
//@CrossOrigin(origins = "http://localhost:4200")
public class KupacController {

    @Autowired
    KupacService kupacService;
    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value="get/all", method = RequestMethod.GET)
    public List<KupacDto> getAll() {
        List<Kupac> kupci = kupacService.findAll();
        return kupci.stream()
                .map(kupac -> modelMapper.map(kupac, KupacDto.class))
                .collect(Collectors.toList());
    }

    @RequestMapping(value="get/{id}", method = RequestMethod.GET)
    public KupacDto getById(@PathVariable int id) {
        Kupac kupac = kupacService.findById(id);
        if (kupac!=null) {
            return modelMapper.map(kupac, KupacDto.class);
        }
        return null;
    }

    @RequestMapping(value="save", method = RequestMethod.POST)
    public KupacDto save(@RequestBody KupacDto kupacDto) {
        System.out.println(kupacDto);
        Kupac kupac = modelMapper.map(kupacDto, Kupac.class);
        kupac = kupacService.saveOrUpdate(kupac);
        return modelMapper.map(kupac, KupacDto.class);
    }

    @RequestMapping(value="update", method= RequestMethod.PUT)
    public KupacDto update(@RequestBody KupacDto kupacDto) {
        Kupac kupac = modelMapper.map(kupacDto, Kupac.class);
        kupac = kupacService.saveOrUpdate(kupac);
        return modelMapper.map(kupac, KupacDto.class);
    }

    @RequestMapping(value="delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        kupacService.delete(id);

    }
}
