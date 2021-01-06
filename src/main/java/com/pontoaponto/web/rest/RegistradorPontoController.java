package com.pontoaponto.web.rest;

import com.pontoaponto.domain.RegistradorPonto;
import com.pontoaponto.service.RegistradorPontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RegistradorPontoController {

    private final RegistradorPontoService registradorPontoService;

    public RegistradorPontoController(RegistradorPontoService registradorPontoService) {
        this.registradorPontoService = registradorPontoService;
    }

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
