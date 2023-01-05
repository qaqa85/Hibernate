package pl.nullpointerexception.batching.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BatchReview.class)
public abstract class BatchReview_ {

	public static volatile SingularAttribute<BatchReview, Long> productId;
	public static volatile SingularAttribute<BatchReview, Integer> rating;
	public static volatile SingularAttribute<BatchReview, Long> id;
	public static volatile SingularAttribute<BatchReview, String> content;

	public static final String PRODUCT_ID = "productId";
	public static final String RATING = "rating";
	public static final String ID = "id";
	public static final String CONTENT = "content";

}

