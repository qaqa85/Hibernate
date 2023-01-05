package pl.nullpointerexception.query.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.SortComparator;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(region = "customer", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDateTime created;
    private LocalDateTime updated;
    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "customer_address")
    private List<Address> address;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL, optional = false)
    private CustomerDetails customerDetails;

    @OneToMany(cascade = CascadeType.PERSIST)
    //@SortNatural
    @SortComparator(SortById.class)
    @JoinColumn(name = "customer_id")
    private SortedSet<Review> reviews = new TreeSet<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Note> notes = new ArrayList<>();

    public static class SortById implements Comparator<Review> {
        @Override
        public int compare(Review o1, Review o2) {
            return o1.getId().compareTo(o2.getId());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public SortedSet<Review> getReviews() {
        return reviews;
    }

    public void setReviews(SortedSet<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstname, customer.firstname) &&
                Objects.equals(lastname, customer.lastname) &&
                Objects.equals(created, customer.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, created);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
