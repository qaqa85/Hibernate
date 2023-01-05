package pl.nullpointerexception.query.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BaseProduct.class)
public abstract class BaseProduct_ {

	public static volatile SingularAttribute<BaseProduct, LocalDateTime> created;
	public static volatile SingularAttribute<BaseProduct, String> name;
	public static volatile SingularAttribute<BaseProduct, String> description;
	public static volatile SingularAttribute<BaseProduct, Long> id;
	public static volatile SingularAttribute<BaseProduct, ProductType> productType;

	public static final String CREATED = "created";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String PRODUCT_TYPE = "productType";

}

