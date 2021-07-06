package com.example.transaction.controller;

import com.example.transaction.dto.TransferRequest;
import com.example.transaction.entity.Rekening;
import com.example.transaction.service.RekeningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rekening")
public class RekeningController {

    @Autowired
    private RekeningService rekeningService;

    @PostMapping
    public Rekening create(@RequestBody Rekening rekening) {

        return rekeningService.create(rekening);
    }

    @GetMapping
    public Iterable<Rekening> findAll() {
        return rekeningService.findAll();
    }

    @PostMapping(path = "/transfer")
    public void transfer(@RequestBody TransferRequest transfer) {
        rekeningService.transfer(transfer.getNorek1(), transfer.getNorek2(), transfer.getAmount());
    }

}
