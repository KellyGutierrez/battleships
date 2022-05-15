package co.edu.umanizales.battleships.service;

import co.edu.umanizales.battleships.model.ListDE;
import co.edu.umanizales.battleships.model.ShipDistribution;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListDEService {
    private ListDE listDE;

    public ListDEService(){
        listDE=new ListDE();

    }

    public String add(ShipDistribution shipDistribution) {
        listDE.add(shipDistribution);
        return "Adicionado con éxito";
    }

    public String allToStart(ShipDistribution shipDistribution) {
        listDE.allToStart(shipDistribution);
        return "Adicionado con éxito";
    }
    public List<ShipDistribution> listNodes(){
        return listDE.listNodes();
    }



}


