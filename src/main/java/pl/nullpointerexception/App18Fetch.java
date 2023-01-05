package pl.nullpointerexception;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.Product;

public class App18Fetch {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
       // entityManager.getTransaction().begin();

        Product product = entityManager.createQuery(
                "SELECT p from Product p " +
                        "left join fetch p.category c" +
                        " WHERE p.id = ?1 and c.id= ?2", Product.class)
                .setParameter(1, 4L)
                .setParameter(2, 1)
                .getSingleResult();

        logger.info(product);
        logger.info(product.getCategory().getName());
        logger.info(product.getReviews());


        //entityManager.getTransaction().commit();
        entityManager.close();

    }
}
