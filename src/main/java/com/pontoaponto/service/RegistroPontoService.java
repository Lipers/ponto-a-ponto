package com.pontoaponto.service;

import com.pontoaponto.domain.RegistroPonto;

import java.util.List;

public interface RegistroPontoService {

    RegistroPonto salvar(RegistroPonto registroPonto);

    List<RegistroPonto> listarTodos();

    List<RegistroPonto> listarTodosPorIdUsuario(long id);
}
