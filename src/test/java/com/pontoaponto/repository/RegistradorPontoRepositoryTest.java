package com.pontoaponto.repository;

import com.pontoaponto.domain.RegistradorPonto;
import com.pontoaponto.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class RegistradorPontoRepositoryTest {

    @Autowired
    RegistradorPontoRepository registradorPontoRepository;

    @Autowired
    UserRepository userRepository;

    @AfterEach
    void terminate() {
        registradorPontoRepository.deleteAll();
    }

    @Test
    void quandoSalvarRegistradorPontoDeveriaSalvarRegistradorPonto() {

        Optional<User> adm = userRepository.findById(3L);
        Instant instante = Instant.now();

        RegistradorPonto registradorPonto = new RegistradorPonto(adm.get(), instante);

        RegistradorPonto pontoSalvado = registradorPontoRepository.save(registradorPonto);

        Assertions.assertEquals("Administrator", pontoSalvado.getUsuario().getFirstName());
        Assertions.assertEquals(registradorPonto.getInstante(), pontoSalvado.getInstante());

    }

    @Test
    void quandoListarTodosOsRegistradorPontoDeveriaListarTodosOsRegistradorPonto() {

        Optional<User> adm = userRepository.findById(3L);
        Optional<User> user = userRepository.findById(4L);
        Instant instante = Instant.now();

        RegistradorPonto registradorPonto1 = new RegistradorPonto(adm.get(), instante);
        RegistradorPonto registradorPonto2 = new RegistradorPonto(user.get(), instante);

        registradorPontoRepository.save(registradorPonto1);
        registradorPontoRepository.save(registradorPonto2);

        List<RegistradorPonto> pontosSalvados = registradorPontoRepository.findAll();

        Assertions.assertEquals(2, pontosSalvados.size());
        Assertions.assertFalse(pontosSalvados.isEmpty());
    }

    @Test
    @Transactional
    void quandoListarRegistradorPontoPorUserIdDeveriaListarTodosOsRegistradorPontoDoUsuario() {

        Optional<User> adm = userRepository.findById(3l);
        Optional<User> user = userRepository.findById(4l);

        RegistradorPonto registradorPontoAdm1 = new RegistradorPonto(adm.get(), Instant.now());
        RegistradorPonto registradorPontoAdm2 = new RegistradorPonto(adm.get(), Instant.now());
        RegistradorPonto registradorPontoUser1 = new RegistradorPonto(user.get(), Instant.now());

        registradorPontoRepository.save(registradorPontoAdm1);
        registradorPontoRepository.save(registradorPontoAdm2);
        registradorPontoRepository.save(registradorPontoUser1);

        List<RegistradorPonto> pontosSalvadosPorIdUsuario = registradorPontoRepository.findAllByUserId(3L);

        Assertions.assertEquals(2, pontosSalvadosPorIdUsuario.size());
        Assertions.assertFalse(pontosSalvadosPorIdUsuario.isEmpty());
    }

}
