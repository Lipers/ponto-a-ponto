package com.pontoaponto.service;

import com.pontoaponto.domain.RegistradorPonto;
import com.pontoaponto.repository.RegistradorPontoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistradorServiceImpl implements RegistradorPontoService {

    private RegistradorPontoRepository repository;

    public RegistradorServiceImpl(RegistradorPontoRepository registradorPontoRepository) {
        this.repository = registradorPontoRepository;
    }

    @Override
    public RegistradorPonto salvar(RegistradorPonto registradorPonto) {
        return repository.save(registradorPonto);
    }

    @Override
    public List<RegistradorPonto> listarTodos() {
        return repository.findAll();
    }

    @Override
    public List<RegistradorPonto> listarTodosPorIdUsuario(Long id) {
        return repository.findAllByUserId(id);
    }
}
