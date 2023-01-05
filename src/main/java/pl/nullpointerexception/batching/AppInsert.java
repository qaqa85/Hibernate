package pl.nullpointerexception.batching;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import pl.nullpointerexception.batching.entity.BatchReview;
import pl.nullpointerexception.hibernate.App;

public class AppInsert {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session unwrap = entityManager.unwrap(Session.class);
        unwrap.setJdbcBatchSize(10);
        entityManager.getTransaction().begin();

        Long singleResult = entityManager.createQuery("select MAX(r.id) FROM BatchReview r", Long.class).getSingleResult();

        for (long i = 1; i < 25; i ++){
            entityManager.persist(new BatchReview(i + singleResult, "New content", 5, 1L));
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
