package pl.nullpointerexception.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flywaydb.core.Flyway;
import pl.nullpointerexception.hibernate.entity.Product;
import pl.nullpointerexception.hibernate.entity.ProductType;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class App {

    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mySqlFactory");

    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:8090/example", "admin", "password")
                .load();
        flyway.migrate();

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Product product = new Product(
                "Rower 01",
                "Opis produktu 01",
                LocalDateTime.now(),
                LocalDateTime.now(),
                new BigDecimal("19.99"),
                ProductType.REAL
        );

        em.persist(product);
        logger.info(product);

        em.getTransaction().commit();
        em.close();

    }
}
