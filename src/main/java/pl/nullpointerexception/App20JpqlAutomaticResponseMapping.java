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

public class App20JpqlAutomaticResponseMapping {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(
                "SELECT " +
                        "new pl.nullpointerexception.query.entity.ProductInCategoryCounterDto (p.category.id, COUNT(p)) " +
                        "from Product p group by p.category"
        );

        List<ProductInCategoryCounterDto> resultList = query.getResultList();
        for (ProductInCategoryCounterDto dto : resultList) {
            logger.info(dto.getCategoryId());
            logger.info(dto.getProductInCategoryCounter());
        }

        //entityManager.getTransaction().commit();
        entityManager.close();
    }
}
