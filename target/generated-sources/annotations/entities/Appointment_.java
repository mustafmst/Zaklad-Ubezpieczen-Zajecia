package entities;

import java.sql.Time;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Appointment.class)
public abstract class Appointment_ {

	public static volatile SingularAttribute<Appointment, Date> dateofAddAppointment;
	public static volatile SingularAttribute<Appointment, Time> hours;
	public static volatile SingularAttribute<Appointment, Integer> appointmentId;
	public static volatile SingularAttribute<Appointment, Integer> id_advisor;
	public static volatile SingularAttribute<Appointment, String> pesel;

}

