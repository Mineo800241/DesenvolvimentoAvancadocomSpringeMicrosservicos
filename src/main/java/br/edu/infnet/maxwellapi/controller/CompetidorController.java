package br.edu.infnet.maxwellapi.controller;

import br.edu.infnet.maxwellapi.model.domain.Competidor;
import br.edu.infnet.maxwellapi.service.CompetidorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <Competidor> incluir(@RequestBody Competidor competidor) {

        Competidor novocompetidor = competidorService.incluir(competidor);

        return ResponseEntity.status(HttpStatus.CREATED).body(novocompetidor);
    }

    @PutMapping(value="/{id}")
    public Competidor alterar(@PathVariable Integer id, @RequestBody Competidor competidor) {
        return competidorService.alterar(id, competidor);
    }

    @DeleteMapping(value="/{id}")
    public  ResponseEntity<Void> excluir(@PathVariable Integer id) {
        competidorService.excluir(id);
        return ResponseEntity.noContent().build();

    }

    @PatchMapping(value="/{id}/inativar")
    public Competidor inativar(@PathVariable Integer id){
        return competidorService.inativar(id);
    }

    @GetMapping
    public ResponseEntity<List<Competidor>> obterLista() {

        List<Competidor> lista = competidorService.obterLista();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(value = "/{id}")
    public Competidor obterPorId(@PathVariable Integer id) {

        return competidorService.obterPorId(id);
    }

}

