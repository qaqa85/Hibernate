package pl.nullpointerexception.query.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrderRow.class)
public abstract class OrderRow_ {

	public static volatile SingularAttribute<OrderRow, Product> product;
	public static volatile SingularAttribute<OrderRow, BigDecimal> price;
	public static volatile SingularAttribute<OrderRow, Long> id;

	public static final String PRODUCT = "product";
	public static final String PRICE = "price";
	public static final String ID = "id";

}

