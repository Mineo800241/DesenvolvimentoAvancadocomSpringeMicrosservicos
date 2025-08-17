package br.edu.infnet.maxwellapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArbitroController {
    @GetMapping("/api/arbitro")
    public String obterNome(){
        return "Lionel E Messi";
    }
}
