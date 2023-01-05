package pl.nullpointerexception.batching;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;

public class AppUpdateQuerying {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        int update = entityManager.createQuery("update Review r SET rating = :rating " +
                "WHERE r.product.id = :id")
                .setParameter("rating", 11)
                .setParameter("id", 1L)
                .executeUpdate();

        logger.info("Updated: " + update + " items");

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
