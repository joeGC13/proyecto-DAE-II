package com.project.demo.controller;

import com.project.demo.model.Producto;
import com.project.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductoController implements GenericController {
    @Autowired
    ProductoService productoService;

    @GetMapping("/productos")
    public String getList(Model model) {
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "producto";
    }

    @Override
    public String save(Object o, Model model) {
        return null;
    }

    @PostMapping("/productos/save")
    public String save(Producto producto, Model model) {
        productoService.create(producto);
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "producto";
    }

    @GetMapping("/productos/add")
    public String add(Model model) {
        model.addAttribute("producto", new Producto());
        return "producto-add";

    }

    @Override
    public String getForUpdate(Object o, Model model) {
        return null;
    }

    @Override
    public String update(Object o, Object o2, Model model) {
        return null;
    }

    @Override
    public String delete(Object o, Model model) {
        return null;
    }

    @GetMapping("/productos/delete/{id}")
    public String delete(Producto producto, Model model) {
        productoService.delete(producto);
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "producto";
    }
}
