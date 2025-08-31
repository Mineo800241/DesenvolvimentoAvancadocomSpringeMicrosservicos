package br.edu.infnet.maxwellapi.controller;

import br.edu.infnet.maxwellapi.model.domain.Arbitro;
import br.edu.infnet.maxwellapi.model.domain.Competidor;
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
            Arbitro novoarbitro = arbitroService.incluir(arbitro);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoarbitro);
    }

    @PutMapping(value="/{id}")
    public Arbitro alterar(@PathVariable Integer id, @RequestBody Arbitro arbitro) {
        return arbitroService.alterar(id, arbitro);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        arbitroService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value="/{id}/inativar")
    public Arbitro inativar(@PathVariable Integer id){
        return arbitroService.inativar(id);
    }

    @GetMapping
    public ResponseEntity<List<Arbitro>> obterLista() {

        List<Arbitro> lista = arbitroService.obterLista();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(value = "/{id}")
    public Arbitro obterPorId(@PathVariable Integer id) {

        return arbitroService.obterPorId(id);
    }

}
