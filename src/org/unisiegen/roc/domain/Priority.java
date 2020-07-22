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
@Table(name = "PRIORITY")
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRIORITY_ID", nullable = false)
    private int priorityId;
    @Column(name = "PRIORITY_NAME", nullable = false)
    private String priorityName;

    @OneToMany(mappedBy = "priority", cascade = {CascadeType.ALL})
    private List<Feedback> feedbackList = new ArrayList<Feedback>();

    /**
     *
     */
    public Priority() {
    }

    /**
     * @return the priorityId
     */
    public int getPriorityId() {
        return priorityId;
    }

    /**
     * @param priorityId the priorityId to set
     */
    public void setPriorityId(int priorityId) {
        this.priorityId = priorityId;
    }

    /**
     * @return the priorityName
     */
    public String getPriorityName() {
        return priorityName;
    }

    /**
     * @param priorityName the priorityName to set
     */
    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
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
        result = prime * result + priorityId;
        result = prime * result + ((priorityName == null) ? 0 : priorityName.hashCode());
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
        Priority other = (Priority) obj;
        if (feedbackList == null) {
            if (other.feedbackList != null) {
                return false;
            }
        } else if (!feedbackList.equals(other.feedbackList)) {
            return false;
        }
        if (priorityId != other.priorityId) {
            return false;
        }
        if (priorityName == null) {
            if (other.priorityName != null) {
                return false;
            }
        } else if (!priorityName.equals(other.priorityName)) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Priority [priorityId=" + priorityId + ", priorityName=" + priorityName + ", feedbackList="
                + feedbackList + "]";
    }

    /**
     * @param priorityId
     * @param priorityName
     * @param feedbackList
     */
    public Priority(int priorityId, String priorityName, List<Feedback> feedbackList) {
        super();
        this.priorityId = priorityId;
        this.priorityName = priorityName;
        this.feedbackList = feedbackList;
    }

}
