package br.edu.infnet.maxwellapi.controller;

import br.edu.infnet.maxwellapi.model.domain.Competidor;
import br.edu.infnet.maxwellapi.model.domain.exceptions.CompetidorInvalidoException;
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

        try{
            Competidor novocompetidor = competidorService.incluir(competidor);
            return ResponseEntity.status(HttpStatus.CREATED).body(novocompetidor);

        }   catch (CompetidorInvalidoException e) {
            return ResponseEntity.badRequest().build();

        }   catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Competidor> alterar(@PathVariable Integer id, @RequestBody Competidor competidor) {
        Competidor competidoralterado = competidorService.alterar(id, competidor);
        return ResponseEntity.ok(competidoralterado);
    }

    @DeleteMapping(value="/{id}")
    public  ResponseEntity<Void> excluir(@PathVariable Integer id) {
        competidorService.excluir(id);
        return ResponseEntity.noContent().build();

    }

    @PatchMapping(value="/{id}/inativar")
    public ResponseEntity<Competidor> inativar(@PathVariable Integer id){
        Competidor competidor = competidorService.inativar(id);
        return ResponseEntity.ok(competidor);
    }

    @GetMapping
    public ResponseEntity<List<Competidor>> obterLista() {

        List<Competidor> lista = competidorService.obterLista();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <Competidor> obterPorId(@PathVariable Integer id) {
        Competidor competidor = competidorService.obterPorId(id);
        return ResponseEntity.ok(competidor);
    }

}

