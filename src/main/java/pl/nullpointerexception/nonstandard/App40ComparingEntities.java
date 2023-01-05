package pl.nullpointerexception.nonstandard;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.Customer;
import pl.nullpointerexception.query.entity.Order;

public class App40ComparingEntities {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        Customer customer = entityManager.find(Customer.class, 1L);
        logger.info(customer.getOrders());

//        entityManager.clear();
//
//        Order order = entityManager.find(Order.class, 4L);
//        logger.info(order.equals(getOrder(customer)));

//        Order order = new Order();
//        order.setTotal(new BigDecimal("19.99"));
//        order.setCreated(LocalDateTime.now());
//        order.setCustomer(customer);
//        entityManager.persist(order);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static Order getOrder(Customer customer) {
        return customer.getOrders().stream()
                .filter(o -> o.getId().equals(4L))
                .findFirst()
                .orElseThrow();
    }
}
