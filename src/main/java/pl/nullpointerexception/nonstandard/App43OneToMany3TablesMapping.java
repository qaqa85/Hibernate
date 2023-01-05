package pl.nullpointerexception.nonstandard;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.Customer;
import pl.nullpointerexception.query.entity.Note;

import java.time.LocalDateTime;

public class App43OneToMany3TablesMapping {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Customer customer = entityManager.find(Customer.class, 2L);
        customer.getNotes().add(new Note("Content 1", LocalDateTime.now()));
        customer.getNotes().add(new Note("Content 2", LocalDateTime.now()));
        customer.getNotes().add(new Note("Content 3", LocalDateTime.now()));
        customer.getNotes().add(new Note("Content 4", LocalDateTime.now()));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
