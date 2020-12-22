package com.pontoaponto.repository;

import com.pontoaponto.domain.RegistroPonto;
import com.pontoaponto.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class RegistroPontoRepositoryTest {

    @Autowired
    RegistroPontoRepository registroPontoRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void quandoRegistrarPontoDeveriaRegistrarPonto() {

        Optional<User> adm = userRepository.findById(3L);
        Instant instante = Instant.now();

        RegistroPonto registroPonto = new RegistroPonto(adm.get(), instante);

        RegistroPonto pontoSalvado = registroPontoRepository.save(registroPonto);

        Assertions.assertEquals("Administrator", pontoSalvado.getUsuario().getFirstName());
        Assertions.assertEquals(registroPonto.getInstante(), pontoSalvado.getInstante());

    }
}
