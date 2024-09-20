package com.example.tarea.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mesa")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numero_mesa", nullable = false, unique = true)
    private int numeroMesa;

    @Column(name = "ocupada", nullable = false)
    private boolean ocupada;

    // Constructor vacío necesario para JPA
    public Mesa() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}
