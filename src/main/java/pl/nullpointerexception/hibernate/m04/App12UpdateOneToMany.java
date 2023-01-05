package pl.nullpointerexception.hibernate.m04;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.hibernate.entity.Product;
import pl.nullpointerexception.hibernate.entity.Review;
import pl.nullpointerexception.hibernate.entity.ReviewDto;

import java.util.ArrayList;
import java.util.List;

public class App12UpdateOneToMany {
    private static Logger logger = LogManager.getLogger(App.class);
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mySqlFactory");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<ReviewDto> reviewDtos = getUpdatedReviews();

        Product product = entityManager.find(Product.class, 3L);
        for (Review review : product.getReviews()) {
            for (ReviewDto reviewDto : reviewDtos) {
                if(review.getId().equals(reviewDto.getId())) {
                    review.setContent(reviewDto.getContend());
                    review.setRating(reviewDto.getRating());
                }
            }
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static List<ReviewDto> getUpdatedReviews() {
        List<ReviewDto> list = new ArrayList<>();
        list.add(new ReviewDto(13L, "Treść opinii 3!!!", 10));
        list.add(new ReviewDto(14L, "Treść opinii 4!!!", 10));
        list.add(new ReviewDto(15L, "Treść opinii 5!!!", 10));
        return list;
    }
}
