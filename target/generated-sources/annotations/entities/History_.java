package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(History.class)
public abstract class History_ {

	public static volatile SingularAttribute<History, Date> dateOfChange;
	public static volatile SingularAttribute<History, String> whatChange;
	public static volatile SingularAttribute<History, Integer> hisId;
	public static volatile SingularAttribute<History, Integer> userId;

}

