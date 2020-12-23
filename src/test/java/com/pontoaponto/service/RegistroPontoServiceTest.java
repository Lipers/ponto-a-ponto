package com.pontoaponto.service;

import com.pontoaponto.domain.RegistroPonto;
import com.pontoaponto.domain.User;
import com.pontoaponto.repository.RegistroPontoRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegistroPontoServiceTest {

    @Test
    void quandoSalvarRegistroPontoDeveriaSalvarRegistroPonto() {
        RegistroPontoRepository registroPontoRepository = mock(RegistroPontoRepository.class);

        User adm = new User();
        adm.setId(3L);
        adm.setFirstName("Administrator");

        RegistroPonto registroPonto = new RegistroPonto(adm, Instant.now());

        when(registroPontoRepository.save(same(registroPonto))).thenReturn(registroPonto);

        RegistroPontoService registroPontoService = new RegistroPontoServiceImpl(registroPontoRepository);

        RegistroPonto registroPontoSalvo = registroPontoService.salvar(registroPonto);

        Assert.assertEquals("Administrator", registroPontoSalvo.getUsuario().getFirstName());

    }


    @Test
    void quandoListarTodosOsRegistroPontoDeveriaListarTodosOsRegistroPonto() {
        RegistroPontoRepository registroPontoRepository = mock(RegistroPontoRepository.class);

        User adm = new User();
        adm.setId(3L);
        adm.setFirstName("Administrator");

        RegistroPonto registroPonto1 = new RegistroPonto(adm, Instant.now());
        RegistroPonto registroPonto2 = new RegistroPonto(adm, Instant.now());

        when(registroPontoRepository.findAll()).thenReturn(Arrays.asList(registroPonto1, registroPonto2));

        RegistroPontoService registroPontoService = new RegistroPontoServiceImpl(registroPontoRepository);

        List<RegistroPonto> registros = registroPontoService.listarTodos();

        Assertions.assertEquals(2, registros.size());

    }

    @Test
    void quandoListarRegistroPontoPorUserIdDeveriaListarTodosOsRegistroPontoDoUsuario() {

        RegistroPontoRepository registroPontoRepository = mock(RegistroPontoRepository.class);

        User adm = new User();
        adm.setId(3L);
        adm.setFirstName("Administrator");

        User user = new User();
        adm.setId(4L);
        adm.setFirstName("User");

        RegistroPonto registroPontoAdm1 = new RegistroPonto(adm, Instant.now());
        RegistroPonto registroPontoAdm2 = new RegistroPonto(adm, Instant.now());
        RegistroPonto registroPontoUser1 = new RegistroPonto(user, Instant.now());

        when(registroPontoRepository.findAllByUserId(3L)).thenReturn(Arrays.asList(registroPontoAdm1, registroPontoAdm2));

        RegistroPontoService registroPontoService = new RegistroPontoServiceImpl(registroPontoRepository);

        registroPontoService.salvar(registroPontoAdm1);
        registroPontoService.salvar(registroPontoAdm2);
        registroPontoService.salvar(registroPontoUser1);

        List<RegistroPonto> pontosSalvadosPorIdUsuario = registroPontoService.listarTodosPorIdUsuario(3L);

        Assertions.assertEquals(2, pontosSalvadosPorIdUsuario.size());
        Assertions.assertFalse(pontosSalvadosPorIdUsuario.isEmpty());
    }
}
