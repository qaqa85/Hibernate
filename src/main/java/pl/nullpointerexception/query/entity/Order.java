package pl.nullpointerexception.query.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "order-rows",
                attributeNodes = {
                        @NamedAttributeNode(value = "orderRows", subgraph = "orderRows"),
                        @NamedAttributeNode("customer")
                }, subgraphs = @NamedSubgraph(name = "orderRows", attributeNodes = @NamedAttributeNode("product"))
        ),
        @NamedEntityGraph(
                name = "order-and-rows",
                attributeNodes = @NamedAttributeNode(value = "orderRows")
        )
})
@Table(name = "\"order\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime created;
    private BigDecimal total;
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "order_id")
    @BatchSize(size = 10)
    //@Fetch(FetchMode.SUBSELECT)
    private Set<OrderRow> orderRows;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    private String uuid = UUID.randomUUID().toString();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Set<OrderRow> getOrderRows() {
        return orderRows;
    }

    public void setOrderRows(Set<OrderRow> orderRows) {
        this.orderRows = orderRows;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(uuid, order.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", created=" + created +
                ", total=" + total +
                '}';
    }
}
