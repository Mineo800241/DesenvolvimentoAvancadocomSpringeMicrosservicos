package br.edu.infnet.maxwellapi.controller;

import br.edu.infnet.maxwellapi.model.domain.Competidor;
import br.edu.infnet.maxwellapi.service.CompetidorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/competidores")
public class CompetidorController {

    private final CompetidorService competidorService;

    public CompetidorController(CompetidorService competidorService) {
        this.competidorService = competidorService;
    }

    @GetMapping
    public Competidor obterCompetidor() {
        return competidorService.obter();
    }
}

