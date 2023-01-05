package pl.nullpointerexception.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.Customer;
import pl.nullpointerexception.query.entity.Customer_;

import java.util.List;

public class App33CriteriaSelect {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
       // Path<String> name = customerRoot.get(Customer_.FIRSTNAME);
        criteriaQuery.select(customerRoot.get(Customer_.FIRSTNAME));

        List<String> query = entityManager.createQuery(criteriaQuery).getResultList();

        for (String customerName : query) {
            logger.info(customerName);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
