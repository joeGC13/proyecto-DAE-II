package com.project.demo.controller;

import com.project.demo.model.Cliente;
import com.project.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ClienteController implements GenericController<Cliente, Integer> {
    @Autowired
    ClienteService service;

    @GetMapping("/clientes/mantenimiento")
    @Override
    public String getList(Model model) {
        List<Cliente> clientes =service.findAll();
        model.addAttribute("clientes", clientes);
        return "cliente-list";
    }

    @GetMapping("/clientes/add")
    @Override
    public String add(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente-add";
    }

    @Override
    public String save(Cliente cliente, Model model) {
        service.create(cliente);
        getList(model);
        return "cliente-list";
    }

    @Override
    public String getForUpdate(Integer id, Model model) {
        return null;
    }

    @Override
    public String update(Integer id, Cliente cliente, Model model) {
        service.update(cliente);
        getList(model);
        return "cliente-list";
    }

    @GetMapping("/clientes/delete/{id}")
    @Override
    public String delete(@PathVariable Integer id, Model model) {
        Cliente cliente = service.findById(id + "");
        service.delete(cliente);
        getList(model);
        return "cliente-list";
    }
}
