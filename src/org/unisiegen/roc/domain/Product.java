/*
 * Institute of Knowledge Based Systems and Knowledge Management,
 * Department of Electrical Engineering and Computer Science,
 * Faculty of Science and Technology, University of Siegen, Germany
 * Winter Semester 2015/16  © 2015-2016 | All right reserved for University of Siegen
 */
package org.unisiegen.roc.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author RebellionPC
 *
 */
@Entity
@Table(name = "PRODUCT_DETAILS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID", nullable = false)
    private int productId;
    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;
    @Column(name = "PRODUCT_DESCRIPTION", nullable = false)
    private String productDescription;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.ALL})
    private List<Model> modelList = new ArrayList<Model>();

    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productDescription
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * @param productDescription the productDescription to set
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * @return the modelList
     */
    public List<Model> getModelList() {
        return modelList;
    }

    /**
     * @param modelList the modelList to set
     */
    public void setModelList(List<Model> modelList) {
        this.modelList = modelList;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((modelList == null) ? 0 : modelList.hashCode());
        result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
        result = prime * result + productId;
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        if (modelList == null) {
            if (other.modelList != null) {
                return false;
            }
        } else if (!modelList.equals(other.modelList)) {
            return false;
        }
        if (productDescription == null) {
            if (other.productDescription != null) {
                return false;
            }
        } else if (!productDescription.equals(other.productDescription)) {
            return false;
        }
        if (productId != other.productId) {
            return false;
        }
        if (productName == null) {
            if (other.productName != null) {
                return false;
            }
        } else if (!productName.equals(other.productName)) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
                + productDescription + ", modelList=" + modelList + "]";
    }

    /**
     * @param productId
     * @param productName
     * @param productDescription
     * @param modelList
     */
    public Product(int productId, String productName, String productDescription, List<Model> modelList) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.modelList = modelList;
    }

    /**
     *
     */
    public Product() {
        super();
    }

}
