package pl.nullpointerexception.hibernate.m04;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.hibernate.entity.Product;
import pl.nullpointerexception.hibernate.entity.Review;

public class App09AddOneToMany {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mySqlFactory");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 5L);
//        Review review = new Review();
//        review.setContent("Nowa opinia");
//        review.setRating(5);
//        //review.setProduct(product);
//        product.addReview(review);
        //entityManager.persist(review);
        Review review = entityManager.find(Review.class, 12L);
        product.addReview(review);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
