package pl.nullpointerexception.batching;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;

public class AppDeleteQuerying {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        int updated = entityManager.createQuery("DELETE FROM Review r WHERE r.product.id = :id")
                .setParameter("id", 2L)
                .executeUpdate();

        logger.info(updated);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
