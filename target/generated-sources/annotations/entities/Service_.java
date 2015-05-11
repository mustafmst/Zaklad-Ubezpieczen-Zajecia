package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Service.class)
public abstract class Service_ {

	public static volatile SingularAttribute<Service, Integer> insuranceCost;
	public static volatile SingularAttribute<Service, Date> dataOfAddService;
	public static volatile SingularAttribute<Service, Integer> serviceCost;
	public static volatile SingularAttribute<Service, String> description;
	public static volatile SingularAttribute<Service, User> userFk;
	public static volatile SingularAttribute<Service, Integer> serviceId;
	public static volatile SingularAttribute<Service, Customer> peselFk;

}

