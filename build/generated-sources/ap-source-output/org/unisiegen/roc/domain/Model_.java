package org.unisiegen.roc.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Model.class)
public abstract class Model_ {

	public static volatile SingularAttribute<Model, String> modelDescription;
	public static volatile SingularAttribute<Model, Product> product;
	public static volatile SingularAttribute<Model, Integer> modelId;
	public static volatile SingularAttribute<Model, String> modelNumber;
	public static volatile ListAttribute<Model, Feedback> feedbackList;

}

