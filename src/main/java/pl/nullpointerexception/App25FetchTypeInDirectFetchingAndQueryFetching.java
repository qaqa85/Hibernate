package pl.nullpointerexception;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.Product;

public class App25FetchTypeInDirectFetchingAndQueryFetching {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //entityManager.getTransaction().begin();

        Product product = entityManager.createQuery(
                        "select p from Product p " +
                                "left join p.category c " +
                                "where p.id = :id and c.id = :catId",
                        Product.class)
                .setParameter("id", 1L)
                .setParameter("catId", 1L)
                .getSingleResult();

//        Product product = entityManager.find(Product.class, 1L);

        logger.info(product);
        logger.info(product.getCategory());

        //entityManager.getTransaction().commit();
        entityManager.close();
    }
}
