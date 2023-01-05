package pl.nullpointerexception.nonstandard;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.Customer;

public class App42SortingAndOrdering {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

//        Product product = entityManager.find(Product.class, 1L);
//
//        Review review = new Review();
//        review.setContent("Content 1");
//        review.setRating(5);
//        review.setProduct(product);
//
//        Review review2 = new Review();
//        review2.setContent("Content 2");
//        review2.setRating(5);
//        review2.setProduct(product);
//
//        Review review3 = new Review();
//        review3.setContent("Content 3");
//        review3.setRating(5);
//        review3.setProduct(product);
//
//
//        Customer customer = entityManager.find(Customer.class, 1L);
//        customer.getReviews().add(review);
//        customer.getReviews().add(review2);
//        customer.getReviews().add(review3);

        Customer customer = entityManager.createQuery(
                        "select c FROM Customer c " +
                                "INNER JOIN FETCH c.reviews r " +
                                "WHERE c.id = :id " +
                                "ORDER BY r.id DESC",
                        Customer.class
                ).setParameter("id", 1L)
                .getSingleResult();

        customer.getReviews().forEach(logger::info);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
