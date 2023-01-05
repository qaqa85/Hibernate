package pl.nullpointerexception.batching;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.batching.entity.BatchReview;
import pl.nullpointerexception.hibernate.App;

import java.util.List;

public class AppUpdate {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Long count = entityManager.createQuery("SELECT COUNT(b) FROM BatchReview b", Long.class).getSingleResult();

        int batchSize = 5;
        for (int i = 0; i < count; i += batchSize) {
            List<BatchReview> batchReviewList = entityManager.createQuery(
                            "SELECT b FROM BatchReview b",
                            BatchReview.class)
                    .setFirstResult(i)
                    .setMaxResults(batchSize)
                    .getResultList();

            logger.info(batchReviewList);


            for (BatchReview batchReview : batchReviewList) {
                batchReview.setContent("Nowa");
                batchReview.setRating(12);
            }

            entityManager.flush();
            entityManager.clear();
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
