package com.pontoaponto.service;

import com.pontoaponto.domain.RegistradorPonto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RegistradorPontoService {

    RegistradorPonto salvar(RegistradorPonto registradorPonto);

    List<RegistradorPonto> listarTodos();

    List<RegistradorPonto> listarTodosPorIdUsuario(Long id);
}
