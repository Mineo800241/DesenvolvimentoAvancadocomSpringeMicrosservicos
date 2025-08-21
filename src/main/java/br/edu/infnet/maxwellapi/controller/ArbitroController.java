package br.edu.infnet.maxwellapi.controller;

import br.edu.infnet.maxwellapi.model.domain.Arbitro;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArbitroController {
    @GetMapping("/api/arbitro")
    public String obterNome(){
        return "Tudo bem!";
    }

    @GetMapping("/api/cadastro")
    public Arbitro obterArbitro(){
            Arbitro arbitro = new Arbitro();
            arbitro.setNome("Maxwell Simoes");
            arbitro.setCpf("000.000.000-00");
            arbitro.setEmail("macs@gol.com");
            arbitro.setTelefone("43 991136662");
            arbitro.setContrato(Boolean.valueOf(true));
            return arbitro;
        }
    }

