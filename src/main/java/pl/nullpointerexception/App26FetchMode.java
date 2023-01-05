package pl.nullpointerexception;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.Order;

import java.util.List;

public class App26FetchMode {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //entityManager.getTransaction().begin();

//        Order order = entityManager.find(Order.class, 1L);
        List<Order> orders = entityManager.createQuery("SELECT o FROM Order o ORDER BY o.created desc", Order.class)
                .setMaxResults(5)
                .getResultList();
//        logger.info(order);
//        logger.info(order.getOrderRows());

        orders.forEach(order -> {
            logger.info(order);
            logger.info(order.getOrderRows());
        });

        //entityManager.getTransaction().commit();
        entityManager.close();
    }
}

