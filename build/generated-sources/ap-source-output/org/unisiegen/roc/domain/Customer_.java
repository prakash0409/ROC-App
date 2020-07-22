package org.unisiegen.roc.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Customer.class)
public abstract class Customer_ {

	public static volatile SingularAttribute<Customer, Long> phoneNumber;
	public static volatile SingularAttribute<Customer, Integer> customerId;
	public static volatile SingularAttribute<Customer, String> contactPerson;
	public static volatile SingularAttribute<Customer, String> emailId;
	public static volatile ListAttribute<Customer, Feedback> feedbackList;
	public static volatile SingularAttribute<Customer, String> customerName;

}

