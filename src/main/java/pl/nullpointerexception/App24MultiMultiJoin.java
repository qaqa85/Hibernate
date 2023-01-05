package pl.nullpointerexception;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.Customer;
import pl.nullpointerexception.query.entity.Order;
import pl.nullpointerexception.query.entity.Product;

import java.util.List;

public class App24MultiMultiJoin {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(
                "select c.id, c.lastname as customer, ca.name as category, SUM(orw.price) as total " +
                        "from Customer c " +
                        "inner join c.orders o " +
                        "inner join o.orderRows orw " +
                        "inner join orw.product p " +
                        "inner join p.category ca " +
                        "group by ca, c " +
                        "having SUM(orw.price) > 50 " +
                        "ORDER BY total DESC"
        );

        List<Object[]> resultList = query.getResultList();
        for (Object[] row : resultList) {
            logger.info(row[0] + ", \t" + row[1] + ", \t" + row[2] + ", \t" + row[3] + ", \t");
        }

        //entityManager.getTransaction().commit();
        entityManager.close();
    }
}
