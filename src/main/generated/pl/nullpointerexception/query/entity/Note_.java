package pl.nullpointerexception.query.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Note.class)
public abstract class Note_ {

	public static volatile SingularAttribute<Note, LocalDateTime> created;
	public static volatile SingularAttribute<Note, Long> id;
	public static volatile SingularAttribute<Note, String> content;

	public static final String CREATED = "created";
	public static final String ID = "id";
	public static final String CONTENT = "content";

}

