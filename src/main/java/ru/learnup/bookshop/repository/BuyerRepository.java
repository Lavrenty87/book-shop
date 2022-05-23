package ru.learnup.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.bookshop.entity.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
