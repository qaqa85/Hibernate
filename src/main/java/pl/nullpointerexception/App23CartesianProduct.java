package pl.nullpointerexception;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.Product;

import java.util.List;

public class App23CartesianProduct {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //entityManager.getTransaction().begin();

        List<Product> resultList = entityManager.createQuery(
                "SELECT  p from Product p " +
                        "left join fetch p.attributes " +
                        "left join fetch p.reviews",
                Product.class).getResultList();
//
//        resultList = entityManager.createQuery(
//                "SELECT p from Product p " +
//                        "left join fetch p.reviews ",
//                Product.class).getResultList();

        logger.info("Size: " + resultList.size());
        for (Product product : resultList) {
            logger.info(product);
            logger.info(product.getAttributes());
            logger.info(product.getReviews());
        }

        //entityManager.getTransaction().commit();
        entityManager.close();
    }
}
