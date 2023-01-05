package pl.nullpointerexception.hibernate.m04;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.hibernate.entity.Category;
import pl.nullpointerexception.hibernate.entity.Product;

public class App07AddOneToOne {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mySqlFactory");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 3L);
        Category category = new Category();
        category.setName("Nowsza kategoria");
        category.setDescription("Opis nowszej kategorii");
        entityManager.persist(category);

        product.setCategory(category);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
