package pl.nullpointerexception.nonstandard;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.Address;
import pl.nullpointerexception.query.entity.AddressType;
import pl.nullpointerexception.query.entity.Customer;

import java.time.LocalDateTime;
import java.util.List;

public class App36ElementCollection {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Customer customer = new Customer();
        customer.setFirstname("Customer1");
        customer.setLastname("Customer1");
        customer.setCreated(LocalDateTime.now());
        customer.setUpdated(LocalDateTime.now());
        customer.setAddress(
                List.of(new Address(AddressType.BILLING, "Polna 10/10", "00-000", "Warszawa"),
                        new Address(AddressType.BILLING, "Letnia 10/10", "00-000", "Warszawa"),
                        new Address(AddressType.BILLING, "Wiosenna 10/10", "00-000", "Warszawa")
                )
        );

        entityManager.persist(customer);
        entityManager.flush();
        entityManager.clear();

        Customer customer1 = entityManager.find(Customer.class, customer.getId());
        logger.info(customer1);
        logger.info(customer1.getAddress());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
