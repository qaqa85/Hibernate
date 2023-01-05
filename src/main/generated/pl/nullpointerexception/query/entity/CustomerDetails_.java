package pl.nullpointerexception.query.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CustomerDetails.class)
public abstract class CustomerDetails_ {

	public static volatile SingularAttribute<CustomerDetails, String> birthPlace;
	public static volatile SingularAttribute<CustomerDetails, LocalDateTime> birthDay;
	public static volatile SingularAttribute<CustomerDetails, String> fatherName;
	public static volatile SingularAttribute<CustomerDetails, String> motherName;
	public static volatile SingularAttribute<CustomerDetails, Long> id;
	public static volatile SingularAttribute<CustomerDetails, String> pesel;
	public static volatile SingularAttribute<CustomerDetails, Customer> customer;

	public static final String BIRTH_PLACE = "birthPlace";
	public static final String BIRTH_DAY = "birthDay";
	public static final String FATHER_NAME = "fatherName";
	public static final String MOTHER_NAME = "motherName";
	public static final String ID = "id";
	public static final String PESEL = "pesel";
	public static final String CUSTOMER = "customer";

}

