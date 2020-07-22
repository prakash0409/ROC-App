/* 
 * Institute of Knowledge Based Systems and Knowledge Management,
 * Department of Electrical Engineering and Computer Science,
 * Faculty of Science and Technology, University of Siegen, Germany
 * Winter Semester 2015/16  © 2015-2016 | All right reserved for University of Siegen
 */
package org.unisiegen.roc.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author RebellionPC
 *
 */
@XmlRootElement
public class FeedbackReport {

    private long feedbackId;
    private String customerName;
    private String contactPerson;
    private String emailId;
    private long phoneNumber;
    private String productName;
    private String modelNumber;
    private String feedbackType;
    private String subject;
    private String issue;
    private String teamAssigned;
    private String priority;
    private String comments;
    private Date feedbackDate;
    private String status;

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FeedbackReport [customerName=" + customerName + ", contactPerson=" + contactPerson + ", emailId="
                + emailId + ", phoneNumber=" + phoneNumber + ", productName=" + productName + ", modelNumber="
                + modelNumber + ", feedbackType=" + feedbackType + ", subject=" + subject + ", issue=" + issue
                + ", teamAssigned=" + teamAssigned + ", priority=" + priority + ", comments=" + comments + "]";
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    @XmlElement
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the feedbackDate
     */
    public Date getFeedbackDate() {
        return feedbackDate;
    }

    /**
     * @param feedbackDate the feedbackDate to set
     */
    @XmlElement
    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    /**
     * @return the feedbackId
     */
    public long getFeedbackId() {
        return feedbackId;
    }

    /**
     * @param feedbackId the feedbackId to set
     */
    @XmlElement
    public void setFeedbackId(long feedbackId) {
        this.feedbackId = feedbackId;
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
    @XmlElement
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
    @XmlElement
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
    @XmlElement
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
    @XmlElement
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
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
    @XmlElement
    public void setProductName(String productName) {
        this.productName = productName;
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
    @XmlElement
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    /**
     * @return the feedbackType
     */
    public String getFeedbackType() {
        return feedbackType;
    }

    /**
     * @param feedbackType the feedbackType to set
     */
    @XmlElement
    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    @XmlElement
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the issue
     */
    public String getIssue() {
        return issue;
    }

    /**
     * @param issue the issue to set
     */
    @XmlElement
    public void setIssue(String issue) {
        this.issue = issue;
    }

    /**
     * @return the teamAssigned
     */
    public String getTeamAssigned() {
        return teamAssigned;
    }

    /**
     * @param teamAssigned the teamAssigned to set
     */
    @XmlElement
    public void setTeamAssigned(String teamAssigned) {
        this.teamAssigned = teamAssigned;
    }

    /**
     * @return the priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    @XmlElement
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    @XmlElement
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     *
     */
    public FeedbackReport() {
    }

}
