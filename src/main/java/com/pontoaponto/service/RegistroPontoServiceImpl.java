package com.pontoaponto.service;

import com.pontoaponto.domain.RegistroPonto;
import com.pontoaponto.repository.RegistroPontoRepository;

import java.util.List;

public class RegistroPontoServiceImpl implements RegistroPontoService {

    private RegistroPontoRepository repository;

    public RegistroPontoServiceImpl(RegistroPontoRepository registroPontoRepository) {
        this.repository = registroPontoRepository;
    }

    @Override
    public RegistroPonto salvar(RegistroPonto registroPonto) {
        return repository.save(registroPonto);
    }

    @Override
    public List<RegistroPonto> listarTodos() {
        return repository.findAll();
    }

    @Override
    public List<RegistroPonto> listarTodosPorIdUsuario(long id) {
        return repository.findAllByUserId(id);
    }
}
