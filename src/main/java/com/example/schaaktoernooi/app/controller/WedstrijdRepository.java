package com.example.schaaktoernooi.app.controller;

import com.example.schaaktoernooi.app.domain.Wedstrijd;
import org.springframework.data.repository.CrudRepository;

public interface WedstrijdRepository extends CrudRepository<Wedstrijd, Long> {
}
