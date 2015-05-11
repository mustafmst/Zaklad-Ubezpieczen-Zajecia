package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> imie;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> stanowisko;
	public static volatile SingularAttribute<User, String> nazwisko;
	public static volatile SingularAttribute<User, String> login;
	public static volatile SingularAttribute<User, Integer> userId;
	public static volatile CollectionAttribute<User, Service> serviceCollection;
	public static volatile SingularAttribute<User, Integer> status;

}

