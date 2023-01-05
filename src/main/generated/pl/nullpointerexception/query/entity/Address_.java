package pl.nullpointerexception.query.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Address.class)
public abstract class Address_ {

	public static volatile SingularAttribute<Address, String> city;
	public static volatile SingularAttribute<Address, AddressType> addressType;
	public static volatile SingularAttribute<Address, String> street;
	public static volatile SingularAttribute<Address, String> postalCode;

	public static final String CITY = "city";
	public static final String ADDRESS_TYPE = "addressType";
	public static final String STREET = "street";
	public static final String POSTAL_CODE = "postalCode";

}

