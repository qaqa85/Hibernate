package pl.nullpointerexception.hibernate.entity;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Attribute.class)
public abstract class Attribute_ {

	public static volatile SingularAttribute<Attribute, String> name;
	public static volatile SingularAttribute<Attribute, Long> id;
	public static volatile SingularAttribute<Attribute, String> value;
	public static volatile SetAttribute<Attribute, Product> products;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String VALUE = "value";
	public static final String PRODUCTS = "products";

}

