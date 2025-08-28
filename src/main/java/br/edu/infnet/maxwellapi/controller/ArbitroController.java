package br.edu.infnet.maxwellapi.controller;

import br.edu.infnet.maxwellapi.model.domain.Arbitro;
import br.edu.infnet.maxwellapi.model.domain.Competidor;
import br.edu.infnet.maxwellapi.model.domain.exceptions.ArbitroInvalidoException;
import br.edu.infnet.maxwellapi.model.domain.exceptions.CompetidorInvalidoException;
import br.edu.infnet.maxwellapi.service.ArbitroService;
import br.edu.infnet.maxwellapi.service.CompetidorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/arbitros")
public class ArbitroController {

    private final ArbitroService arbitroService;

    public ArbitroController(ArbitroService arbitroService) {
        this.arbitroService = arbitroService;
    }

    @PostMapping
    public ResponseEntity<Arbitro> incluir(@RequestBody Arbitro arbitro) {

        try{
            Arbitro novoarbitro = arbitroService.incluir(arbitro);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoarbitro);

        }   catch (ArbitroInvalidoException e) {
            return ResponseEntity.badRequest().build();

        }   catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Arbitro> alterar(@PathVariable Integer id, @RequestBody Arbitro arbitro) {
        Arbitro arbitroalterado = arbitroService.alterar(id, arbitro);
        return ResponseEntity.ok(arbitroalterado);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        arbitroService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value="/{id}/inativar")
    public ResponseEntity<Arbitro> inativar(@PathVariable Integer id){
        Arbitro arbitro = arbitroService.inativar(id);
        return ResponseEntity.ok(arbitro);
    }

    @GetMapping
    public ResponseEntity<List<Arbitro>> obterLista() {

        List<Arbitro> lista = arbitroService.obterLista();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <Arbitro> obterPorId(@PathVariable Integer id) {
            Arbitro arbitro = arbitroService.obterPorId(id);
            return ResponseEntity.ok(arbitro);
        }

}
