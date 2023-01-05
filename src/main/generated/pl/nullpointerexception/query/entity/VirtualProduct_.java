package pl.nullpointerexception.query.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VirtualProduct.class)
public abstract class VirtualProduct_ extends pl.nullpointerexception.query.entity.BaseProduct_ {

	public static volatile SingularAttribute<VirtualProduct, Boolean> downloadable;
	public static volatile SingularAttribute<VirtualProduct, String> fileName;
	public static volatile SingularAttribute<VirtualProduct, String> filePath;

	public static final String DOWNLOADABLE = "downloadable";
	public static final String FILE_NAME = "fileName";
	public static final String FILE_PATH = "filePath";

}

