package com.example.tarea.service;

import com.example.tarea.model.Mesa;
import com.example.tarea.model.Plato;
import com.example.tarea.repository.MesaRepository;
import com.example.tarea.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantManager {

    @Autowired
    private PlatoRepository platoRepository;

    @Autowired
    private MesaRepository mesaRepository;

    public void agregarPlato(Plato plato) {
        platoRepository.save(plato);
    }

    public void agregarMesa(Mesa mesa) {
        mesaRepository.save(mesa);
    }

    public List<Plato> listarPlatos() {
        return platoRepository.findAll();
    }

    public List<Mesa> listarMesas() {
        return mesaRepository.findAll();
    }

    public void actualizarPlato(Plato plato) {
        platoRepository.save(plato);
    }

    public void actualizarMesa(Mesa mesa) {
        mesaRepository.save(mesa);
    }

    public void eliminarPlato(int id) {
        platoRepository.deleteById(id);
    }

    public void eliminarMesa(int id) {
        mesaRepository.deleteById(id);
    }
}
