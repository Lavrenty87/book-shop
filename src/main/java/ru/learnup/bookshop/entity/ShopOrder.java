package ru.learnup.bookshop.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@ToString()
@RequiredArgsConstructor
public class ShopOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Buyer buyer;

    @OneToMany(mappedBy = "shop_order")
    @ToString.Exclude
    private List<OrderDetails> order_details;

    @Column
    private Integer sumBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ShopOrder shopOrder = (ShopOrder) o;
        return id != null && Objects.equals(id, shopOrder.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
