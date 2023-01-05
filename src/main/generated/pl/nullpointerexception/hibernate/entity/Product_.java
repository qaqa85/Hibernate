package pl.nullpointerexception.hibernate.entity;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile ListAttribute<Product, Review> reviews;
	public static volatile SingularAttribute<Product, LocalDateTime> created;
	public static volatile SingularAttribute<Product, BigDecimal> price;
	public static volatile SingularAttribute<Product, String> name;
	public static volatile SingularAttribute<Product, String> description;
	public static volatile SetAttribute<Product, Attribute> attributes;
	public static volatile SingularAttribute<Product, Long> id;
	public static volatile SingularAttribute<Product, Category> category;
	public static volatile SingularAttribute<Product, LocalDateTime> updated;
	public static volatile SingularAttribute<Product, ProductType> productType;

	public static final String REVIEWS = "reviews";
	public static final String CREATED = "created";
	public static final String PRICE = "price";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ATTRIBUTES = "attributes";
	public static final String ID = "id";
	public static final String CATEGORY = "category";
	public static final String UPDATED = "updated";
	public static final String PRODUCT_TYPE = "productType";

}

