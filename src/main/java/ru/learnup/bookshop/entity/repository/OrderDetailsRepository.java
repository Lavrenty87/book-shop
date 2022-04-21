package ru.learnup.bookshop.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.bookshop.entity.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}
