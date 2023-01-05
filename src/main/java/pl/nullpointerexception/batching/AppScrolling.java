package pl.nullpointerexception.batching;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.jpa.AvailableHints;
import pl.nullpointerexception.batching.entity.BatchReview;
import pl.nullpointerexception.hibernate.App;

public class AppScrolling {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createQuery(
                        "SELECT b FROM BatchReview b",
                        BatchReview.class)
                .setHint(AvailableHints.HINT_FETCH_SIZE, Integer.MIN_VALUE)
                .getResultStream()
                .forEach(batchReview -> {
                    batchReview.setContent("steaming");
                    batchReview.setRating(9);
                });

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

