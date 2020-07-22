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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author RebellionPC
 *
 */
@Entity
@Table(name = "MODEL")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MODEL_ID", nullable = false)
    private int modelId;
    @Column(name = "MODEL_NUMBER", nullable = false)
    private String modelNumber;
    @Column(name = "MODEL_DESCRIPTION", nullable = false)
    private String modelDescription;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    @OneToMany(mappedBy = "model", cascade = {CascadeType.ALL})
    private List<Feedback> feedbackList = new ArrayList<Feedback>();

    /**
     *
     */
    public Model() {
    }

    /**
     * @return the modelId
     */
    public int getModelId() {
        return modelId;
    }

    /**
     * @param modelId the modelId to set
     */
    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    /**
     * @return the modelNumber
     */
    public String getModelNumber() {
        return modelNumber;
    }

    /**
     * @param modelNumber the modelNumber to set
     */
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    /**
     * @return the modelDescription
     */
    public String getModelDescription() {
        return modelDescription;
    }

    /**
     * @param modelDescription the modelDescription to set
     */
    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the feedbackList
     */
    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    /**
     * @param feedbackList the feedbackList to set
     */
    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((feedbackList == null) ? 0 : feedbackList.hashCode());
        result = prime * result + ((modelDescription == null) ? 0 : modelDescription.hashCode());
        result = prime * result + modelId;
        result = prime * result + ((modelNumber == null) ? 0 : modelNumber.hashCode());
        result = prime * result + ((product == null) ? 0 : product.hashCode());
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
        Model other = (Model) obj;
        if (feedbackList == null) {
            if (other.feedbackList != null) {
                return false;
            }
        } else if (!feedbackList.equals(other.feedbackList)) {
            return false;
        }
        if (modelDescription == null) {
            if (other.modelDescription != null) {
                return false;
            }
        } else if (!modelDescription.equals(other.modelDescription)) {
            return false;
        }
        if (modelId != other.modelId) {
            return false;
        }
        if (modelNumber == null) {
            if (other.modelNumber != null) {
                return false;
            }
        } else if (!modelNumber.equals(other.modelNumber)) {
            return false;
        }
        if (product == null) {
            if (other.product != null) {
                return false;
            }
        } else if (!product.equals(other.product)) {
            return false;
        }
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Model [modelId=" + modelId + ", modelNumber=" + modelNumber + ", modelDescription=" + modelDescription
                + ", product=" + product + ", feedbackList=" + feedbackList + "]";
    }

    /**
     * @param modelId
     * @param modelNumber
     * @param modelDescription
     * @param product
     * @param feedbackList
     */
    public Model(int modelId, String modelNumber, String modelDescription, Product product,
            List<Feedback> feedbackList) {
        super();
        this.modelId = modelId;
        this.modelNumber = modelNumber;
        this.modelDescription = modelDescription;
        this.product = product;
        this.feedbackList = feedbackList;
    }

}
