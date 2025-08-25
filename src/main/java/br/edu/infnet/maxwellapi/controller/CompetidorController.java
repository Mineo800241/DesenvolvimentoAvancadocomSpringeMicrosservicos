package br.edu.infnet.maxwellapi.controller;

import br.edu.infnet.maxwellapi.model.domain.Competidor;
import br.edu.infnet.maxwellapi.service.CompetidorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/competidores")
public class CompetidorController {

    private final CompetidorService competidorService;

    public CompetidorController(CompetidorService competidorService) {
        this.competidorService = competidorService;
    }

    @GetMapping
    public List<Competidor> obterLista() {
        return competidorService.obterLista();
    }

    // Usar essa ideia para separar por categoria de faixas, por idade e por peso.
    @GetMapping(value = "/{id}")
    public Competidor obterPorId(@PathVariable Integer id) {

        return competidorService.obterPorId(id);
    }

    @RequestMapping("/api/competidores/feminino")
    @GetMapping(value = "/{sexo}")
    public Competidor obterPorSexo(@PathVariable String sexo) {

        return competidorService.obterPorSexo(sexo);
    }
}

