package pl.nullpointerexception;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.Category;
import pl.nullpointerexception.query.entity.Product;

import java.util.List;

public class App22MultiJoin {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //entityManager.getTransaction().begin();

        TypedQuery<Category> select = entityManager.createQuery(
                "Select c from Category c " +
                        "left join fetch c.products p " +
                        "left join fetch p.reviews " +
                        "where c.id=:id",
                Category.class);

        select.setParameter("id", 1L);

        List<Category> resultList = select.getResultList();
        for (Category category : resultList) {
            logger.info(category);
            logger.info(category.getProduct());
            for (Product product : category.getProduct()) {
                logger.info(product.getReviews());
            }
        }

        //entityManager.getTransaction().commit();
        entityManager.close();
    }
}
