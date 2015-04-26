package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Customer.class)
public abstract class Customer_ {

	public static volatile SingularAttribute<Customer, String> firstName;
	public static volatile SingularAttribute<Customer, String> lastName;
	public static volatile SingularAttribute<Customer, Integer> phone;
	public static volatile SingularAttribute<Customer, String> adress;
	public static volatile SingularAttribute<Customer, String> pesel;
	public static volatile CollectionAttribute<Customer, Service> serviceCollection;
	public static volatile SingularAttribute<Customer, String> email;

}

