package ru.learnup.bookshop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.learnup.bookshop.entity.Warehouse;
import ru.learnup.bookshop.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/waerhouse")
public class WaerhouseRestController {
    private final WarehouseService service;

    public WaerhouseRestController(WarehouseService service) {
        this.service = service;
    }

    private List<Warehouse> getWarehouses(){
        return service.getWarehouses();
    }
}
