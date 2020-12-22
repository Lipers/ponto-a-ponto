package com.pontoaponto.repository;

import com.pontoaponto.domain.RegistroPonto;
import com.pontoaponto.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

@SpringBootTest
public class RegistroPontoRepositoryTest {

    @Autowired
    RegistroPontoRepository registroPontoRepository;


    @Test
    void quandoRegistrarPontoDeveriaRegistrarPonto() {

        User joao = new User();
        joao.setFirstName("João");

//        Instant instante = Instant.now();

        RegistroPonto registroPonto = new RegistroPonto("asd");

        RegistroPonto pontoSalvado = registroPontoRepository.save(registroPonto);

//        Assertions.assertEquals("João", pontoSalvado.getUsuario().getFirstName());
//        Assertions.assertEquals("2020-12-22T17:52:36.526762Z", pontoSalvado.getInstante());

    }
}
