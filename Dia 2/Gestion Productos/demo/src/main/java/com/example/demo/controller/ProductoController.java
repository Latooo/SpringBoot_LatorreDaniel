package com.example.demo.controller;

import com.example.demo.model.Producto;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class ProductoController {

    private final List<Producto> productos = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();
    private final Scanner scanner = new Scanner(System.in);

    public void runConsole() {
        boolean running = true;
        while (running) {
            System.out.println("\nMenú:");
            System.out.println("1. Crear producto");
            System.out.println("2. Leer producto");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Listar productos");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearProducto();
                    break;
                case 2:
                    leerProducto();
                    break;
                case 3:
                    actualizarProducto();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 5:
                    listarProductos();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void crearProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();  // Limpiar el buffer

        Producto producto = new Producto(counter.incrementAndGet(), nombre, precio);
        productos.add(producto);
        System.out.println("Producto creado: " + producto);
    }

    private void leerProducto() {
        System.out.print("ID del producto a leer: ");
        Long id = scanner.nextLong();
        scanner.nextLine();  // Limpiar el buffer

        Producto producto = productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (producto != null) {
            System.out.println("Producto encontrado: " + producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void actualizarProducto() {
        System.out.print("ID del producto a actualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine();  // Limpiar el buffer

        Producto producto = productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (producto != null) {
            System.out.print("Nuevo nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Nuevo precio del producto: ");
            double precio = scanner.nextDouble();
            scanner.nextLine();  // Limpiar el buffer

            producto.setNombre(nombre);
            producto.setPrecio(precio);
            System.out.println("Producto actualizado: " + producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void eliminarProducto() {
        System.out.print("ID del producto a eliminar: ");
        Long id = scanner.nextLong();
        scanner.nextLine();  // Limpiar el buffer

        boolean removed = productos.removeIf(p -> p.getId().equals(id));

        if (removed) {
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en la lista.");
        } else {
            System.out.println("Lista de productos:");
            productos.forEach(System.out::println);
        }
    }
}
