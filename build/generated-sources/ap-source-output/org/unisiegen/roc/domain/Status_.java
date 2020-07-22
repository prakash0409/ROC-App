package org.unisiegen.roc.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Status.class)
public abstract class Status_ {

	public static volatile SingularAttribute<Status, String> statusDescription;
	public static volatile SingularAttribute<Status, Integer> statusId;
	public static volatile ListAttribute<Status, Feedback> feedbackList;

}

