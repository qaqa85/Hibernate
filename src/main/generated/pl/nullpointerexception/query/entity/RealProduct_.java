package pl.nullpointerexception.query.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RealProduct.class)
public abstract class RealProduct_ extends pl.nullpointerexception.query.entity.BaseProduct_ {

	public static volatile SingularAttribute<RealProduct, Integer> width;
	public static volatile SingularAttribute<RealProduct, Integer> length;
	public static volatile SingularAttribute<RealProduct, Float> weight;
	public static volatile SingularAttribute<RealProduct, Integer> height;

	public static final String WIDTH = "width";
	public static final String LENGTH = "length";
	public static final String WEIGHT = "weight";
	public static final String HEIGHT = "height";

}

