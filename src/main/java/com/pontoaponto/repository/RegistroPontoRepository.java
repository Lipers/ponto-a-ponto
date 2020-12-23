package com.pontoaponto.repository;

import com.pontoaponto.domain.RegistroPonto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistroPontoRepository extends JpaRepository<RegistroPonto, Long> {

    @Query("select rep from registro_ponto rep where rep.usuario_id = :id")
    List<RegistroPonto> findAllByUserId(@Param("id") Long id);
}
