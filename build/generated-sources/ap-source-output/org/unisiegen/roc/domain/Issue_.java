package org.unisiegen.roc.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Issue.class)
public abstract class Issue_ {

	public static volatile SingularAttribute<Issue, Integer> issueId;
	public static volatile SingularAttribute<Issue, String> issueName;
	public static volatile ListAttribute<Issue, ResolvingTeam> teamList;
	public static volatile ListAttribute<Issue, Feedback> feedbackList;

}

