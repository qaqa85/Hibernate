package pl.nullpointerexception.hibernate.m04;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.hibernate.entity.Attribute;
import pl.nullpointerexception.hibernate.entity.Product;

import java.util.ArrayList;

public class App11DeleteManyToMany {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mySqlFactory");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        //Product product = entityManager.find(Product.class, 5L);
        //entityManager.remove(product);
        //product.getAttributes().clear();

        Attribute attribute = entityManager.find(Attribute.class, 1L);

        new ArrayList<>(attribute.getProducts())
                .forEach(attribute::removeProduct);

        entityManager.remove(attribute);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
