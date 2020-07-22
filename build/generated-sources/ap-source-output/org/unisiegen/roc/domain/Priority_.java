package org.unisiegen.roc.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Priority.class)
public abstract class Priority_ {

	public static volatile SingularAttribute<Priority, String> priorityName;
	public static volatile ListAttribute<Priority, Feedback> feedbackList;
	public static volatile SingularAttribute<Priority, Integer> priorityId;

}

