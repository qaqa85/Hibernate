package pl.nullpointerexception.query.entity;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, BigDecimal> total;
	public static volatile SingularAttribute<Order, LocalDateTime> created;
	public static volatile SingularAttribute<Order, Long> id;
	public static volatile SingularAttribute<Order, String> uuid;
	public static volatile SetAttribute<Order, OrderRow> orderRows;
	public static volatile SingularAttribute<Order, Customer> customer;

	public static final String TOTAL = "total";
	public static final String CREATED = "created";
	public static final String ID = "id";
	public static final String UUID = "uuid";
	public static final String ORDER_ROWS = "orderRows";
	public static final String CUSTOMER = "customer";

}

