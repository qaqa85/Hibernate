package pl.nullpointerexception.hibernate.m04;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.hibernate.entity.Product;

public class App10DeleteOneToOne {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mySqlFactory");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 3L);
        if (product.getCategory().getProducts().size() == 1) {
            entityManager.remove(product.getCategory());
        }
        product.setCategory(null);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
