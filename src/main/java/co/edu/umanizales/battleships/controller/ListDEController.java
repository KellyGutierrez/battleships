package co.edu.umanizales.battleships.controller;

import co.edu.umanizales.battleships.model.ListDE;
import co.edu.umanizales.battleships.model.Ship;
import co.edu.umanizales.battleships.model.ShipDistribution;
import co.edu.umanizales.battleships.service.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/listde")
public class ListDEController {
    @Autowired
    private ListDEService listDEService;

    @PostMapping
    public String add(@RequestBody Ship ship)
    {
        return listDEService.add(new ShipDistribution(ship));

    }

    @PostMapping(path = "/tostart")
    public String addToStart(@RequestBody Ship ship)
    {
        return listDEService.allToStart(new ShipDistribution(ship));

    }
    @GetMapping
    public List<ShipDistribution> listAll()
    {
        return listDEService.listNodes();
    }


}
