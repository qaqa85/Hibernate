package pl.nullpointerexception;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.Order;

import java.util.List;

public class App29NplusOne {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        EntityGraph entityGraph = entityManager.getEntityGraph("order-and-rows");
//        List<Order> order = entityManager.createQuery(
//                "select distinct o from Order o",
//                Order.class
//        )
//                .setHint("jakarta.persistence.fetchgraph", entityGraph)
//                .getResultList();
//
//        logger.info("Number of orders: " + order.size());
//        for (Order order1 : order) {
//            logger.info(order1.getId());
//            logger.info(order1.getOrderRows());
//        }

        List<Order> order = entityManager.createQuery(
                "select o from Order o",
                Order.class
        ).getResultList();

        logger.info("Number of orders: " + order.size());
        for (Order order1 : order) {
            logger.info(order1.getId());
            logger.info(order1.getOrderRows());
        }
//        }


            entityManager.close();
    }
}
