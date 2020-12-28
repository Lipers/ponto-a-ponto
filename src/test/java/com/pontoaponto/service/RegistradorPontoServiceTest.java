package com.pontoaponto.service;

import com.pontoaponto.domain.RegistradorPonto;
import com.pontoaponto.domain.User;
import com.pontoaponto.repository.RegistradorPontoRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegistradorPontoServiceTest {

    @Test
    void quandoSalvarRegistradorPontoDeveriaSalvarRegistradorPonto() {
        RegistradorPontoRepository registradorPontoRepository = mock(RegistradorPontoRepository.class);

        User adm = new User();
        adm.setId(3L);
        adm.setFirstName("Administrator");

        RegistradorPonto registradorPonto = new RegistradorPonto(adm, Instant.now());

        when(registradorPontoRepository.save(same(registradorPonto))).thenReturn(registradorPonto);

        RegistradorPontoService registradorPontoService = new RegistradorServiceImpl(registradorPontoRepository);

        RegistradorPonto registradorPontoSalvo = registradorPontoService.salvar(registradorPonto);

        Assert.assertEquals("Administrator", registradorPontoSalvo.getUsuario().getFirstName());

    }


    @Test
    void quandoListarTodosOsRegistradorPontoDeveriaListarTodosOsRegistradorPonto() {
        RegistradorPontoRepository registradorPontoRepository = mock(RegistradorPontoRepository.class);

        User adm = new User();
        adm.setId(3L);
        adm.setFirstName("Administrator");

        RegistradorPonto registradorPonto1 = new RegistradorPonto(adm, Instant.now());
        RegistradorPonto registradorPonto2 = new RegistradorPonto(adm, Instant.now());

        when(registradorPontoRepository.findAll()).thenReturn(Arrays.asList(registradorPonto1, registradorPonto2));

        RegistradorPontoService registradorPontoService = new RegistradorServiceImpl(registradorPontoRepository);

        List<RegistradorPonto> registros = registradorPontoService.listarTodos();

        Assertions.assertEquals(2, registros.size());

    }

    @Test
    void quandoListarRegistradorPontoPorUserIdDeveriaListarTodosOsRegistradorPontoDoUsuario() {

        RegistradorPontoRepository registradorPontoRepository = mock(RegistradorPontoRepository.class);

        User adm = new User();
        adm.setId(3L);
        adm.setFirstName("Administrator");

        User user = new User();
        adm.setId(4L);
        adm.setFirstName("User");

        RegistradorPonto registradorPontoAdm1 = new RegistradorPonto(adm, Instant.now());
        RegistradorPonto registradorPontoAdm2 = new RegistradorPonto(adm, Instant.now());
        RegistradorPonto registradorPontoUser1 = new RegistradorPonto(user, Instant.now());

        when(registradorPontoRepository.findAllByUserId(3L)).thenReturn(Arrays.asList(registradorPontoAdm1, registradorPontoAdm2));

        RegistradorPontoService registradorPontoService = new RegistradorServiceImpl(registradorPontoRepository);

        registradorPontoService.salvar(registradorPontoAdm1);
        registradorPontoService.salvar(registradorPontoAdm2);
        registradorPontoService.salvar(registradorPontoUser1);

        List<RegistradorPonto> pontosSalvadosPorIdUsuario = registradorPontoService.listarTodosPorIdUsuario(3L);

        Assertions.assertEquals(2, pontosSalvadosPorIdUsuario.size());
        Assertions.assertFalse(pontosSalvadosPorIdUsuario.isEmpty());
    }
}
