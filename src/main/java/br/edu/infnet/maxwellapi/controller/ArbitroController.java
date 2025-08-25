package br.edu.infnet.maxwellapi.controller;

import br.edu.infnet.maxwellapi.model.domain.Arbitro;
import br.edu.infnet.maxwellapi.model.domain.Competidor;
import br.edu.infnet.maxwellapi.service.ArbitroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/arbitros")
public class ArbitroController {

    private final ArbitroService arbitroService;

    public ArbitroController(ArbitroService arbitroService) {
        this.arbitroService = arbitroService;
    }

    @GetMapping
    public List<Arbitro> obterLista() {
        return arbitroService.obterLista();
    }

    @GetMapping(value = "/{id}")
    public Arbitro obterPorId(@PathVariable Integer id) {
        return arbitroService.obterPorId(id);
    }
}
