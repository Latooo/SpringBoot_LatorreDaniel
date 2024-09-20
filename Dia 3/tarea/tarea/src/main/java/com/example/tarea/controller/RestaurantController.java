package com.example.tarea.controller;

import com.example.tarea.model.Mesa;
import com.example.tarea.model.Plato;
import com.example.tarea.service.RestaurantManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantManager restaurantManager;

    @PostMapping("/plato")
    public void agregarPlato(@RequestBody Plato plato) {
        restaurantManager.agregarPlato(plato);
    }

    @PostMapping("/mesa")
    public void agregarMesa(@RequestBody Mesa mesa) {
        restaurantManager.agregarMesa(mesa);
    }

    @GetMapping("/platos")
    public List<Plato> listarPlatos() {
        return restaurantManager.listarPlatos();
    }

    @GetMapping("/mesas")
    public List<Mesa> listarMesas() {
        return restaurantManager.listarMesas();
    }

    @PutMapping("/plato")
    public void actualizarPlato(@RequestBody Plato plato) {
        restaurantManager.actualizarPlato(plato);
    }

    @PutMapping("/mesa")
    public void actualizarMesa(@RequestBody Mesa mesa) {
        restaurantManager.actualizarMesa(mesa);
    }

    @DeleteMapping("/plato/{id}")
    public void eliminarPlato(@PathVariable int id) {
        restaurantManager.eliminarPlato(id);
    }

    @DeleteMapping("/mesa/{id}")
    public void eliminarMesa(@PathVariable int id) {
        restaurantManager.eliminarMesa(id);
    }
}
