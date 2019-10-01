package pe.isil.isilweb.service;

import org.springframework.stereotype.Service;
import pe.isil.isilweb.model.Colaborador;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

@Service
public class ColaboradorService {

    List<Colaborador> colaboradors = new ArrayList<>(
            Arrays.asList(
                    new Colaborador("C01", "CCC","DDD","EEE","FFF","GGG","10-10-10","III","JJJ","10","1")

            )
    );

    public List<Colaborador> getAll(){
        return colaboradors;
    }

    public void saveColaborador(Colaborador colaborador){
        colaboradors.add(colaborador);
    }

    public void deleteColaborador(Colaborador colaborador){
        colaboradors.remove(colaborador);
    }

    public void updateColaborador(Colaborador colaborador){
        Colaborador currentColaborador = findById(colaborador.getCola_id());
        int index = colaboradors.indexOf(currentColaborador);
        colaborador.setCola_id(currentColaborador.getCola_id());
        colaboradors.set(index, colaborador);
    }

    public Colaborador findById(String documentNumber){
        Colaborador colaborador = colaboradors.stream()
                .filter(s -> s.getCola_id()
                        .equalsIgnoreCase(documentNumber))
                .findFirst()
                .orElseGet(null);
        return colaborador;
    }

}
