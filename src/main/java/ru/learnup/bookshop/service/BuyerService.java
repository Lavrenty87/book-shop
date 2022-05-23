package ru.learnup.bookshop.service;

import org.springframework.stereotype.Service;
import ru.learnup.bookshop.entity.Buyer;
import ru.learnup.bookshop.repository.BuyerRepository;

import java.util.List;

@Service
public class BuyerService {

    private final BuyerRepository buyerRepository;

    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }
    public List<Buyer> getBuyer() {
        return buyerRepository.findAll();
    }
}
