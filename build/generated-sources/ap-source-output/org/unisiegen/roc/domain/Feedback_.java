package org.unisiegen.roc.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Feedback.class)
public abstract class Feedback_ {

	public static volatile SingularAttribute<Feedback, String> comments;
	public static volatile SingularAttribute<Feedback, Issue> issue;
	public static volatile SingularAttribute<Feedback, ResolvingTeam> resolvingTeam;
	public static volatile SingularAttribute<Feedback, String> subject;
	public static volatile SingularAttribute<Feedback, Date> feedbackDate;
	public static volatile SingularAttribute<Feedback, Long> feedbackId;
	public static volatile SingularAttribute<Feedback, Model> model;
	public static volatile SingularAttribute<Feedback, Priority> priority;
	public static volatile SingularAttribute<Feedback, Integer> feedbackType;
	public static volatile SingularAttribute<Feedback, User> user;
	public static volatile SingularAttribute<Feedback, Customer> customer;
	public static volatile SingularAttribute<Feedback, Status> status;

}

