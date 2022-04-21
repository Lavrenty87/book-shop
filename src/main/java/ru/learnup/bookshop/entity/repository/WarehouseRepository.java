package ru.learnup.bookshop.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.bookshop.entity.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
