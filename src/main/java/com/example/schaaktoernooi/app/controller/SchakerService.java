package com.example.schaaktoernooi.app.controller;

import com.example.schaaktoernooi.app.domain.Schaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SchakerService {

    @Autowired
    private SchakerRepository schakerRepository;

    public Iterable<Schaker> alleSchakersService() {
        return schakerRepository.findAll();
    }
}
