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
@Table(name = "STATUS")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATUS_ID", nullable = false)
    private int statusId;
    @Column(name = "STATUS_DESCRIPTION", nullable = false)
    private String statusDescription;

    @OneToMany(mappedBy = "status", cascade = {CascadeType.ALL})
    private List<Feedback> feedbackList = new ArrayList<Feedback>();

    /**
     *
     */
    public Status() {
    }

    /**
     * @return the statusId
     */
    public int getStatusId() {
        return statusId;
    }

    /**
     * @param statusId the statusId to set
     */
    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    /**
     * @return the statusDescription
     */
    public String getStatusDescription() {
        return statusDescription;
    }

    /**
     * @param statusDescription the statusDescription to set
     */
    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
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
        result = prime * result + ((statusDescription == null) ? 0 : statusDescription.hashCode());
        result = prime * result + statusId;
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
        Status other = (Status) obj;
        if (feedbackList == null) {
            if (other.feedbackList != null) {
                return false;
            }
        } else if (!feedbackList.equals(other.feedbackList)) {
            return false;
        }
        if (statusDescription == null) {
            if (other.statusDescription != null) {
                return false;
            }
        } else if (!statusDescription.equals(other.statusDescription)) {
            return false;
        }
        if (statusId != other.statusId) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Status [statusId=" + statusId + ", statusDescription=" + statusDescription + ", feedbackList="
                + feedbackList + "]";
    }

    /**
     * @param statusId
     * @param statusDescription
     * @param feedbackList
     */
    public Status(int statusId, String statusDescription, List<Feedback> feedbackList) {
        super();
        this.statusId = statusId;
        this.statusDescription = statusDescription;
        this.feedbackList = feedbackList;
    }

}
