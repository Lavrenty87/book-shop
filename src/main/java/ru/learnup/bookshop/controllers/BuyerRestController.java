package ru.learnup.bookshop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.learnup.bookshop.entity.Buyer;
import ru.learnup.bookshop.service.BuyerService;

import java.util.List;

@RestController
@RequestMapping("/buyer")
public class BuyerRestController {
    private final BuyerService buyerService;

    public BuyerRestController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    public List<Buyer> getBuyers(@RequestParam(value = "fio", required = false) String fio){
        return buyerService.getBuyer();
    }
}
