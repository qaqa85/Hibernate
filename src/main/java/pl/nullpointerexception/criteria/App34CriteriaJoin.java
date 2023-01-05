package pl.nullpointerexception.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.Customer;
import pl.nullpointerexception.query.entity.Customer_;
import pl.nullpointerexception.query.entity.Order_;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class App34CriteriaJoin {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
        Join<Object, Object> orders = (Join<Object, Object>) customerRoot.fetch("orders", JoinType.INNER);
        orders.fetch("orderRows")
                .fetch("product");
//        ParameterExpression<Long> id1 = criteriaBuilder.parameter(Long.class);
//        ParameterExpression<Long> id2 = criteriaBuilder.parameter(Long.class);
        ParameterExpression<String> lastName = criteriaBuilder.parameter(String.class);
        ParameterExpression<BigDecimal> total = criteriaBuilder.parameter(BigDecimal.class);
        ParameterExpression<Collection> ids = criteriaBuilder.parameter(Collection.class);

        criteriaQuery.select(customerRoot)
                .where(
                        criteriaBuilder.and(
                                criteriaBuilder.or(
//                                        criteriaBuilder.like(
//                                                customerRoot.get(Customer_.LASTNAME),
//                                                criteriaBuilder.concat(lastName, "%"))
                                        customerRoot.get(Customer_.ID).in(ids)
                                ),
                                criteriaBuilder.between(
                                        orders.get(Order_.TOTAL), total,
                                        criteriaBuilder.literal(new BigDecimal("70.00"))
                                ),
                                criteriaBuilder.isNotNull(customerRoot.get(Customer_.FIRSTNAME))
                        )
                );

        TypedQuery<Customer> query = entityManager.createQuery(criteriaQuery);
//        query.setParameter(id1, 1L);
//        query.setParameter(id2, 2L);
      //  query.setParameter(lastName, "Kow");
        query.setParameter(total, new BigDecimal("30.00"));
        query.setParameter(ids, Arrays.asList(1L, 2L, 3L));

        List<Customer> resultList = query.getResultList();

        for (Customer customer : resultList) {
            logger.info(customer);
//            customer.getOrders().forEach(order -> {
//                logger.info(order);
//                order.getOrderRows().forEach(orderRow -> {
//                    logger.info(orderRow);
//                    logger.info(orderRow.getProduct());
//                });
//            });
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
