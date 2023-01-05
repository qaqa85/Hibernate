package pl.nullpointerexception;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.ProductInCategoryCounterDto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class App19JpqlResponseMapping {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(
                "SELECT p.category.id, COUNT(p) from Product p group by p.category"
        );
        var result = ((List<Object[]>) query.getResultList()).stream()
                .map(objects -> new ProductInCategoryCounterDto((Long) objects[0], (Long) objects[1]))
                .collect(Collectors.toList());


        for (ProductInCategoryCounterDto dto : result) {
            logger.info(dto.getCategoryId());
            logger.info(dto.getProductInCategoryCounter());
        }
        //entityManager.getTransaction().commit();
        entityManager.close();
    }
}
