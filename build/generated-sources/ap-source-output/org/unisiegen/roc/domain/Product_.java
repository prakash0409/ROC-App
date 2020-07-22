package org.unisiegen.roc.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile ListAttribute<Product, Model> modelList;
	public static volatile SingularAttribute<Product, Integer> productId;
	public static volatile SingularAttribute<Product, String> productName;
	public static volatile SingularAttribute<Product, String> productDescription;

}

