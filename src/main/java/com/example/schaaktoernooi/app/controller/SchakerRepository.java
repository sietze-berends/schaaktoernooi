package com.example.schaaktoernooi.app.controller;

import com.example.schaaktoernooi.app.domain.Schaker;
import org.springframework.data.repository.CrudRepository;

public interface SchakerRepository extends CrudRepository<Schaker, Long> {
}
