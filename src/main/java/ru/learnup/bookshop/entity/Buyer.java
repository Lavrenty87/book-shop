package ru.learnup.bookshop.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String FIO;
    @Column
    private LocalDate birth_date;
    @OneToMany(mappedBy = "buyer")
    private List<ShopOrder> shopOrders;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Buyer buyer = (Buyer) o;
        return id != null && Objects.equals(id, buyer.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
