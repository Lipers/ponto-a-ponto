package com.pontoaponto.repository;

import com.pontoaponto.domain.RegistroPonto;
import com.pontoaponto.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RegistroPontoRepositoryTest {

    @Autowired
    RegistroPontoRepository registroPontoRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void quandoSalvarRegistroPontoDeveriaRegistrarPonto() {

        Optional<User> adm = userRepository.findById(3L);
        Instant instante = Instant.now();

        RegistroPonto registroPonto = new RegistroPonto(adm.get(), instante);

        RegistroPonto pontoSalvado = registroPontoRepository.save(registroPonto);

        Assertions.assertEquals("Administrator", pontoSalvado.getUsuario().getFirstName());
        Assertions.assertEquals(registroPonto.getInstante(), pontoSalvado.getInstante());

    }

    @Test
    void quandoListarTodosOsRegistroPontoDeveriaListarTodosOsRegistroPonto() {

        Optional<User> adm = userRepository.findById(3L);
        Optional<User> user = userRepository.findById(4L);
        Instant instante = Instant.now();

        RegistroPonto registroPonto1 = new RegistroPonto(adm.get(), instante);
        RegistroPonto registroPonto2 = new RegistroPonto(user.get(), instante);

        registroPontoRepository.save(registroPonto1);
        registroPontoRepository.save(registroPonto2);

        List<RegistroPonto> pontosSalvados = registroPontoRepository.findAll();

        Assertions.assertEquals(2, pontosSalvados.size());
        Assertions.assertFalse(pontosSalvados.isEmpty());
    }

    //TODO : QuerySyntaxException: registro_ponto is not mapped
    @Test
    void quandoListarRegistroPontoPorUserIdDeveriaListarTodosOsRegistroPontoDoUsuario() {

        User adm = new User();
        adm.setId(3L);
        adm.setFirstName("Administrator");

        User user = new User();
        adm.setId(4L);
        adm.setFirstName("User");

        RegistroPonto registroPontoAdm1 = new RegistroPonto(adm, Instant.now());
        RegistroPonto registroPontoAdm2 = new RegistroPonto(adm, Instant.now());
        RegistroPonto registroPontoUser1 = new RegistroPonto(user, Instant.now());

        registroPontoRepository.save(registroPontoAdm1);
        registroPontoRepository.save(registroPontoAdm2);
        registroPontoRepository.save(registroPontoUser1);

        List<RegistroPonto> pontosSalvadosPorIdUsuario = registroPontoRepository.findAllByUserId(3L);

        Assertions.assertEquals(2, pontosSalvadosPorIdUsuario.size());
        Assertions.assertFalse(pontosSalvadosPorIdUsuario.isEmpty());
    }

}
