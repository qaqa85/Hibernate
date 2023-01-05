package pl.nullpointerexception.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.*;
import pl.nullpointerexception.query.entity.Order;

import java.util.List;

public class App35CriteriaAggregations {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Customer> customer = criteriaQuery.from(Customer.class);

        SetJoin<Customer, Order> orders = customer.join(Customer_.orders, JoinType.INNER);
        Join<Object, Object> orderRow = orders.join(Order_.ORDER_ROWS);
        Join<Object, Object> product = orderRow.join(OrderRow_.PRODUCT);
        Join<Object, Object> category = product.join(Product_.CATEGORY);

//        criteriaQuery.select(
//                criteriaBuilder.array(
//                        customer.get(Customer_.ID),
//                        customer.get(Customer_.LASTNAME),
//                        category.get(Category_.NAME)
//                )
//        );

        criteriaQuery.multiselect(
                        customer.get(Customer_.ID),
                        customer.get(Customer_.LASTNAME),
                        category.get(Category_.ID),
                        criteriaBuilder.sum(orderRow.get(OrderRow_.PRICE)))
                .groupBy(category.get(Category_.ID), customer.get(Customer_.ID))
                .orderBy(criteriaBuilder.desc(criteriaBuilder.sum(orderRow.get(OrderRow_.PRICE))))
                .having(criteriaBuilder.gt(criteriaBuilder.sum(orderRow.get(OrderRow_.PRICE)), 50));

        TypedQuery<Object[]> query = entityManager.createQuery(criteriaQuery);
        List<Object[]> resultList = query.getResultList();
        for (Object[] row : resultList) {
            logger.info(row[0] + ", " + row[1] + ", " + row[2] + ", " + row[3]);
        }


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
