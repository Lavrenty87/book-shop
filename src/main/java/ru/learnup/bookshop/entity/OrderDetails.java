package ru.learnup.bookshop.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OrderDetails {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private OrderDetails order_details;
    @OneToOne
    private Book book;
    @Column
    private Integer count;
    @Column
    private Integer prise;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderDetails that = (OrderDetails) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
