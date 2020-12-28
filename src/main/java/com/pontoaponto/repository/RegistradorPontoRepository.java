package com.pontoaponto.repository;

import com.pontoaponto.domain.RegistradorPonto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface RegistradorPontoRepository extends JpaRepository<RegistradorPonto, Long> {

    @Transactional
    @Query(value = "SELECT * FROM REGISTRADOR_PONTO WHERE usuario_id = :id", nativeQuery = true)
    List<RegistradorPonto> findAllByUserId(@Param("id") Long id);
}
