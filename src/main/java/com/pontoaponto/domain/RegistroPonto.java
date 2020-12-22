package com.pontoaponto.domain;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table
public class RegistroPonto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name="id")
//    private User usuario;

    @Column
    private String momentoRegistrado;

    public RegistroPonto(String momentoRegistrado) {
//        this.usuario = joao;
        this.momentoRegistrado = momentoRegistrado;
    }


//    public User getUsuario() {
//        return this.usuario;
//    }

//    public Instant getInstante() {
//        return this.momentoRegistrado;
//    }
}
