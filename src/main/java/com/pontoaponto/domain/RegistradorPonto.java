package com.pontoaponto.domain;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table
public class RegistradorPonto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User usuario;

    @Column(columnDefinition="TIMESTAMP")
    @UpdateTimestamp
    private Instant momentoRegistrado;

    public RegistradorPonto(User usuario, Instant momentoRegistrado) {
        this.usuario = usuario;
        this.momentoRegistrado = momentoRegistrado;
    }

    public RegistradorPonto() {

    }

    public User getUsuario() {
        return this.usuario;
    }

    public Instant getInstante() {
        return this.momentoRegistrado;
    }
}
