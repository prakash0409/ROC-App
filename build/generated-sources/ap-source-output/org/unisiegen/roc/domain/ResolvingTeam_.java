package org.unisiegen.roc.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ResolvingTeam.class)
public abstract class ResolvingTeam_ {

	public static volatile SingularAttribute<ResolvingTeam, String> emailAddress;
	public static volatile SingularAttribute<ResolvingTeam, Integer> teamId;
	public static volatile ListAttribute<ResolvingTeam, Issue> issueList;
	public static volatile SingularAttribute<ResolvingTeam, String> teamDescription;
	public static volatile ListAttribute<ResolvingTeam, Feedback> feedbackList;

}

