package br.edu.infnet.maxwellapi.controller;

import br.edu.infnet.maxwellapi.model.domain.Competidor;
import br.edu.infnet.maxwellapi.service.CompetidorService;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/competidores")
public class CompetidorController {

    private final CompetidorService competidorService;

    public CompetidorController(CompetidorService competidorService) {
        this.competidorService = competidorService;
    }


    @PostMapping
    public Competidor incluir(@RequestBody Competidor competidor) {
        return competidorService.incluir(competidor);
    }
    @PutMapping(value="/{id}")
    public Competidor alterar(@PathVariable Integer id, @RequestBody Competidor competidor) {
        return competidorService.alterar(id, competidor);
    }

    @PatchMapping(value="/{id}/inativar")
    public Competidor inativar(@PathVariable Integer id){
        return competidorService.inativar(id);
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

//    @GetMapping("/{feminino}")
//    public Competidor obterPorSexo(@PathVariable String sexo) {
//
//        return competidorService.obterPorId(sexo);
//    }

}

