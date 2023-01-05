package pl.nullpointerexception.query.entity;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Customer.class)
public abstract class Customer_ {

	public static volatile SingularAttribute<Customer, String> firstname;
	public static volatile ListAttribute<Customer, Address> address;
	public static volatile ListAttribute<Customer, Note> notes;
	public static volatile SetAttribute<Customer, Review> reviews;
	public static volatile SingularAttribute<Customer, LocalDateTime> created;
	public static volatile SetAttribute<Customer, Order> orders;
	public static volatile SingularAttribute<Customer, Long> id;
	public static volatile SingularAttribute<Customer, CustomerDetails> customerDetails;
	public static volatile SingularAttribute<Customer, LocalDateTime> updated;
	public static volatile SingularAttribute<Customer, String> lastname;

	public static final String FIRSTNAME = "firstname";
	public static final String ADDRESS = "address";
	public static final String NOTES = "notes";
	public static final String REVIEWS = "reviews";
	public static final String CREATED = "created";
	public static final String ORDERS = "orders";
	public static final String ID = "id";
	public static final String CUSTOMER_DETAILS = "customerDetails";
	public static final String UPDATED = "updated";
	public static final String LASTNAME = "lastname";

}

