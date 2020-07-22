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
@Table(name = "CUSTOMER_DETAILS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID", nullable = false)
    private int customerId;
    @Column(name = "CUSTOMER_NAME", nullable = false)
    private String customerName;
    @Column(name = "CONTACT_PERSON", nullable = false)
    private String contactPerson;
    @Column(name = "EMAIL_ID", nullable = false)
    private String emailId;
    @Column(name = "PHONE_NUMBER", nullable = false)
    private long phoneNumber;

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL})
    private List<Feedback> feedbackList = new ArrayList<Feedback>();

    /**
     *
     */
    public Customer() {
    }

    /**
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the contactPerson
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * @param contactPerson the contactPerson to set
     */
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    /**
     * @return the emailId
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * @param emailId the emailId to set
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * @return the phoneNumber
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        result = prime * result + ((contactPerson == null) ? 0 : contactPerson.hashCode());
        result = prime * result + customerId;
        result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
        result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
        result = prime * result + ((feedbackList == null) ? 0 : feedbackList.hashCode());
        result = prime * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
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
        Customer other = (Customer) obj;
        if (contactPerson == null) {
            if (other.contactPerson != null) {
                return false;
            }
        } else if (!contactPerson.equals(other.contactPerson)) {
            return false;
        }
        if (customerId != other.customerId) {
            return false;
        }
        if (customerName == null) {
            if (other.customerName != null) {
                return false;
            }
        } else if (!customerName.equals(other.customerName)) {
            return false;
        }
        if (emailId == null) {
            if (other.emailId != null) {
                return false;
            }
        } else if (!emailId.equals(other.emailId)) {
            return false;
        }
        if (feedbackList == null) {
            if (other.feedbackList != null) {
                return false;
            }
        } else if (!feedbackList.equals(other.feedbackList)) {
            return false;
        }
        if (phoneNumber != other.phoneNumber) {
            return false;
        }
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", contactPerson="
                + contactPerson + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber + ", feedbackList="
                + feedbackList + "]";
    }

    /**
     * @param customerId
     * @param customerName
     * @param contactPerson
     * @param emailId
     * @param phoneNumber
     * @param feedbackList
     */
    public Customer(int customerId, String customerName, String contactPerson, String emailId, long phoneNumber,
            List<Feedback> feedbackList) {
        super();
        this.customerId = customerId;
        this.customerName = customerName;
        this.contactPerson = contactPerson;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.feedbackList = feedbackList;
    }

}
