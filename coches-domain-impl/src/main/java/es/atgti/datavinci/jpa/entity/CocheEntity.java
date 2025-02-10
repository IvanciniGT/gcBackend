package es.atgti.datavinci.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "coches")
public class CocheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "matricula", nullable = false, unique = true)
    private String matricula;

    private String marca;

    private String modelo;

    private Integer potencia;

}

/*
CREATE TABLE coches (
    id INT PRIMARY KEY,
    matricula VARCHAR(255) NOT NULL,
    marca VARCHAR(255),
    modelo VARCHAR(255),
    potencia INT
    )

 CREATE UNIQUE INDEX matricula_idx ON coches (matricula);
 */