package com.pontoaponto.web.rest;

import com.pontoaponto.domain.RegistradorPonto;
import com.pontoaponto.service.RegistradorPontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class RegistradorPontoController {

    @Autowired
    private RegistradorPontoService registradorPontoService;

    @GetMapping(value = "/pontos")
    public ResponseEntity<List<RegistradorPonto>> getAll() {
        return ResponseEntity.ok().body(registradorPontoService.listarTodos());
    }

    @GetMapping(value = "/pontos/{id}")
    public ResponseEntity<List<RegistradorPonto>> getAllByUserId(@PathVariable long id) {
        return ResponseEntity.ok().body(registradorPontoService.listarTodosPorIdUsuario(id));
    }

    @PostMapping(value = "ponto")
    public ResponseEntity<RegistradorPonto> createRegistradorPonto(@RequestBody RegistradorPonto registradorPonto) {
        return ResponseEntity.ok().body(this.registradorPontoService.salvar(registradorPonto));
    }
}
