package pl.nullpointerexception.nonstandard;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.query.entity.Customer;
import pl.nullpointerexception.query.entity.CustomerDetails;

import java.time.LocalDateTime;

public class App37IdsMapping {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpql");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Customer customer = entityManager.find(Customer.class, 6L);
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setBirthPlace("Warszawa");
        customerDetails.setBirthDay(LocalDateTime.of(2000, 10, 22, 0,0));
        customerDetails.setFatherName("Jan");
        customerDetails.setMotherName("Janina");
        customerDetails.setPesel("1111111");
        customerDetails.setCustomer(customer);
        customer.setCustomerDetails(customerDetails);
        entityManager.persist(customer);

        logger.info(customer);
        logger.info(customer.getCustomerDetails());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
