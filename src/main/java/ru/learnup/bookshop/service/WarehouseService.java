package ru.learnup.bookshop.service;

import org.springframework.stereotype.Service;
import ru.learnup.bookshop.entity.Warehouse;
import ru.learnup.bookshop.repository.WarehouseRepository;

import java.util.List;

@Service
public class WarehouseService {
    private final WarehouseRepository repository;

    public WarehouseService(WarehouseRepository repository) {
        this.repository = repository;
    }

    public List<Warehouse> getWarehouses(){
        return repository.findAll();
    }
}
