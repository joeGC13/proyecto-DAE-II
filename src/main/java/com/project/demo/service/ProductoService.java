package com.project.demo.service;

import com.project.demo.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductoService implements GenericService<Producto, String>{

    List<Producto> productos = new ArrayList<>(
            Arrays.asList(
                    new Producto(
                            1, "22132315", "Leche Gloria", "Lacteos", 2.4, true
                    ),
                    new Producto(
                            2, "12312311", "Chizito", "Pickeos", 1.2, true
                    ),
                    new Producto(
                            2, "12312312", "Chizito", "Pickeos", 1.2, true
                    )
            )
    );

    @Override
    public void create(Producto producto) {
        productos.add(producto);
    }

    @Override
    public void update(Producto producto) {
        Producto currentProduct = findById(String.valueOf(producto.getId()));
        int index = productos.indexOf(currentProduct);
        productos.set(index, producto);
    }

    @Override
    public void delete(Producto producto) {
        productos.remove(producto);
    }

    @Override
    public List<Producto> findAll() {
        return productos;
    }

    @Override
    public Producto findById(String s) {
        return productos.stream()
                .filter(p -> Integer.parseInt(s) == p.getId())
                .findFirst()
                .orElse(null);
    }
}
