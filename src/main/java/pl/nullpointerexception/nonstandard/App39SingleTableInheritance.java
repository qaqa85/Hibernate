package pl.nullpointerexception.nonstandard;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.RealProduct;
import pl.nullpointerexception.query.entity.VirtualProduct;

import java.time.LocalDateTime;

public class App39SingleTableInheritance {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        VirtualProduct virtualProduct = new VirtualProduct();
        virtualProduct.setName("Virtual");
        virtualProduct.setDescription("Desc virtual");
        virtualProduct.setCreated(LocalDateTime.now());
        virtualProduct.setDownloadable(true);
        virtualProduct.setFileName("test.txt");
        virtualProduct.setFilePath("/store");
        entityManager.persist(virtualProduct);

        RealProduct realProduct = new RealProduct();
        realProduct.setName("Real");
        realProduct.setDescription("Desc real");
        realProduct.setCreated(LocalDateTime.now());
        realProduct.setWeight(10.5f);
        realProduct.setWeight(20);
        realProduct.setWidth(20);
        realProduct.setLength(10);
        realProduct.setHeight(30);
        entityManager.persist(realProduct);

        entityManager.flush();
        entityManager.clear();

        logger.info(entityManager.find(VirtualProduct.class, virtualProduct.getId()));
        logger.info(entityManager.find(RealProduct.class, realProduct.getId()));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
