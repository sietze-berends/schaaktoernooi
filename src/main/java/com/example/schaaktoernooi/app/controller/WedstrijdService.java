package com.example.schaaktoernooi.app.controller;

import com.example.schaaktoernooi.app.domain.Schaker;
import com.example.schaaktoernooi.app.domain.Wedstrijd;
import com.example.schaaktoernooi.app.dto.WedstrijdDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class WedstrijdService {

    @Autowired
    WedstrijdRepository wedstrijdRepository;

    @Autowired
    SchakerRepository schakerRepository;

    public Iterable<WedstrijdDTO> toonWedstrijdenService() {
        List<WedstrijdDTO> wedstrijden = new ArrayList<>();

        for(Wedstrijd wedstrijd : wedstrijdRepository.findAll()) {
            String naam1 = wedstrijd.getSpeler1().getVoornaam() + " " + wedstrijd.getSpeler1().getAchternaam();
            String naam2 = wedstrijd.getSpeler2().getVoornaam() + " " + wedstrijd.getSpeler2().getAchternaam();
            String datum = wedstrijd.getDatum().toString();
            String winnaar = Objects.toString(wedstrijd.getWinnaar(),"n.n.b.");

            wedstrijden.add(new WedstrijdDTO(String.valueOf(wedstrijd.getId()), naam1, naam2, datum, winnaar));
        }


        return wedstrijden;
    }

    public void voegWedstrijdToeService(WedstrijdDTO wedstrijdDTO) {
        // initialize the start date and end date
        String wedDatumString = wedstrijdDTO.getDatum();
        String wedstrijdDatumString[] = wedDatumString.split("-");
        LocalDate wedstrijdDatum = LocalDate.of(Integer.valueOf(wedstrijdDatumString[0]),
                Integer.valueOf(wedstrijdDatumString[1]), Integer.valueOf(wedstrijdDatumString[2]));
        Long id1 = Long.valueOf(wedstrijdDTO.getSpeler1().split("-")[0].replace(" ", ""));
        Long id2 = Long.valueOf(wedstrijdDTO.getSpeler2().split("-")[0].replace(" ", ""));
        Schaker schaker1 = schakerRepository.findById(id1).get();
        Schaker schaker2 = schakerRepository.findById(id2).get();

        Wedstrijd wedstrijd = new Wedstrijd(schaker1, schaker2, wedstrijdDatum);
        System.out.println(wedstrijd);
        wedstrijdRepository.save(wedstrijd);
    }
}
