package com.project.demo.service;

import com.project.demo.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClienteService implements GenericService<Cliente, String> {
    List<Cliente> clientes = new ArrayList<>(
            Arrays.asList(
                    new Cliente(1, "71236500", "Jose", "Lopez", "Garcia", true),
                    new Cliente(2, "09691320", "Rodrigo", "Espinoza", "del Valle", true))
    );

    @Override
    public void create(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        Cliente currentCliente = findById(cliente.getId());
        int index = clientes.indexOf(cliente);
        clientes.set(index, currentCliente);
    }

    @Override
    public void delete(Cliente cliente) {
        clientes.remove(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clientes;
    }

    @Override
    public Cliente findById(String s) {
        Cliente currentCliente = clientes.stream()
                .filter(c -> c.getId() == Integer.parseInt(s))
                .findFirst()
                .orElse(null);

        return currentCliente;
    }
}
