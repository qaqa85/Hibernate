package pl.nullpointerexception;

import jakarta.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.Order;
import pl.nullpointerexception.query.entity.OrderRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App28EntityGraph {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        EntityGraph entityGraph = entityManager.getEntityGraph("order-rows");
//        Map<String, Object> map = new HashMap<>();
//       // map.put("jakarta.persistence.fetchgraph", entityGraph);
//        map.put("jakarta.persistence.loadgraph", entityGraph);
//
//        Order order = entityManager.find(Order.class, 1L, map);
//
//        logger.info(order);
//        for (OrderRow orderRow : order.getOrderRows()) {
//            logger.info(orderRow);
//            logger.info(orderRow.getProduct());
//        }
        EntityGraph entityGraph = entityManager.createEntityGraph(Order.class);
        entityGraph.addAttributeNodes("orderRows");
        entityGraph.addAttributeNodes("customer");
        Subgraph<OrderRow> orderRows = entityGraph.addSubgraph("orderRows");
        orderRows.addAttributeNodes("product");

        Map<String, Object> map = new HashMap<>();
        // map.put("jakarta.persistence.fetchgraph", entityGraph);
        map.put("jakarta.persistence.loadgraph", entityGraph);

        //Order order = entityManager.find(Order.class, 1L, map);
        List<Order> selectOFromOrderO = entityManager.createQuery(
                        "select o from Order o",
                        Order.class)
                .setHint("jakarta.persistence.fetchgraph", entityGraph)
                .getResultList();

        for (Order order : selectOFromOrderO) {
            logger.info(order);
            for (OrderRow orderRow : order.getOrderRows()) {
                logger.info(orderRow);
                logger.info(orderRow.getProduct());
            }
        }



        entityManager.close();
    }
}
