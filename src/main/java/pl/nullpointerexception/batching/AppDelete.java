package pl.nullpointerexception.batching;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.batching.entity.BatchReview;
import pl.nullpointerexception.hibernate.App;

import java.util.List;

public class AppDelete {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<BatchReview> review = entityManager.createQuery(
                        "SELECT r FROM BatchReview r WHERE r.productId = :id",
                        BatchReview.class)
                .setParameter("id", 1L)
                .getResultList();

        for (BatchReview batchReview : review) {
            logger.info(batchReview);
            entityManager.remove(batchReview);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
