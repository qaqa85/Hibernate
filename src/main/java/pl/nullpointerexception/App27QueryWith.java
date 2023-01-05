package pl.nullpointerexception;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.Order;

import java.util.List;

public class App27QueryWith {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Order> orders = entityManager.createQuery(
                        "SELECT o FROM Order o WHERE o.id NOT IN (:ids)",
                        Order.class)
                .setParameter("ids", List.of(1L, 3L, 5L))
                .getResultList();

        orders.forEach(order -> {
            logger.info(order);
        });

        entityManager.close();
    }
}
