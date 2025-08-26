package br.edu.infnet.maxwellapi.controller;

import br.edu.infnet.maxwellapi.model.domain.Arbitro;
import br.edu.infnet.maxwellapi.model.domain.Competidor;
import br.edu.infnet.maxwellapi.service.ArbitroService;
import br.edu.infnet.maxwellapi.service.CompetidorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/arbitros")
public class ArbitroController {

    private final ArbitroService arbitroService;
    private final CompetidorService competidorService;

    public ArbitroController(ArbitroService arbitroService, CompetidorService competidorService) {
        this.arbitroService = arbitroService;
        this.competidorService = competidorService;
    }

    @GetMapping
    public List<Arbitro> obterLista() {
        return arbitroService.obterLista();
    }

    @GetMapping(value = "/{id}")
    public Arbitro obterPorId(@PathVariable Integer id) {
        return arbitroService.obterPorId(id);
    }

    @PostMapping
    public Arbitro incluir(@RequestBody Arbitro arbitro) {
        return arbitroService.incluir(arbitro);
    }

    @PutMapping(value="/{id}")
    public Arbitro alterar(@PathVariable Integer id, @RequestBody Arbitro arbitro) {
        return arbitroService.alterar(id, arbitro);
    }

    @DeleteMapping(value="/{id}")
    public void excluir(@PathVariable Integer id) {
        arbitroService.excluir(id);
    }

    @PatchMapping(value="/{id}/inativar")
    public Arbitro inativar(@PathVariable Integer id){
        return arbitroService.inativar(id);
    }



}
