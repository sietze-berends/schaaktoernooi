package com.example.schaaktoernooi.app.controller;

import com.example.schaaktoernooi.app.domain.Schaker;
import com.example.schaaktoernooi.app.dto.SchakerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
public class SchakerService {

    @Autowired
    private SchakerRepository schakerRepository;

    public Iterable<Schaker> alleSchakersService() {
        return schakerRepository.findAll();
    }

    public void schakerToevoegenService(SchakerDTO schakerDTO) {
        // initialize the start date and end date
        String gbdatumstring = schakerDTO.getGeboortedatum();
        String geboorteDatumString[] = gbdatumstring.split("-");
        LocalDate geboortedatum = LocalDate.of(Integer.valueOf(geboorteDatumString[0]),
                Integer.valueOf(geboorteDatumString[1]), Integer.valueOf(geboorteDatumString[2]));

        schakerRepository.save(new Schaker(schakerDTO.getVoornaam(), schakerDTO.getAchternaam(),
                schakerDTO.getTussenvoegsel(), geboortedatum));
    }

    public void verwijderSchakerService(Long id) {
        schakerRepository.deleteById(id);
    }
}
