package pe.isil.isilweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.isilweb.model.Colaborador;
import pe.isil.isilweb.service.ColaboradorService;


import java.util.List;

public class ColaboradorController {

    @Autowired
    ColaboradorService colboradorService;

    @GetMapping("/colaboradors")
    public String getColaboradorList(Model model){
        List<Colaborador> colaboradors = colboradorService.getAll();
        model.addAttribute("colaborador", colaboradors);
        return "colaborador";
    }

    @PostMapping("/colaboradors/save")
    public String saveColaborador(Colaborador colaborador, Model model){
        //save
        colboradorService.saveColaborador(colaborador);

        //list
        List<Colaborador> colaboradors = colboradorService.getAll();
        model.addAttribute("colaboradors", colaboradors);
        return "colaborador";
    }

    @GetMapping("/colaboradors/add")
    public String addColaborador(Model model){
        model.addAttribute("colaborador", new Colaborador());
        return "colaborador-add";
    }

    @GetMapping("/colaboradors/edit/{cola_id}")
    public String getColaboradorForUpdate (@PathVariable String cola_id,
                                       Model model){

        Colaborador currentColaborador = colboradorService.findById(cola_id);
        model.addAttribute("colaborador", currentColaborador);
        return "colaborador-edit";
    }

    @PostMapping("/colaboradors/update/{cola_id}")
    public String updateColaborador(@PathVariable String cola_id,
                                Colaborador colaborador,
                                Model model){

        //Update
        colboradorService.updateColaborador(colaborador);

        //list
        List<Colaborador> colaboradors = colboradorService.getAll();
        model.addAttribute("colaboradors", colaboradors);
        return "colaborador";
    }

    @GetMapping("/colaboradors/delete/{cola_id}")
    public String deleteColaborador(@PathVariable String cola_id,
                                Model model){

        Colaborador currentColaborador = colboradorService.findById(cola_id);

        //Delete
        colboradorService.deleteColaborador(currentColaborador);

        //list
        List<Colaborador> colaboradors = colboradorService.getAll();
        model.addAttribute("colaboradors", colaboradors);
        return "colaborador";
    }


}
