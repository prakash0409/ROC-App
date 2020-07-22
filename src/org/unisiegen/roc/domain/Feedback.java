/*
 * Institute of Knowledge Based Systems and Knowledge Management,
 * Department of Electrical Engineering and Computer Science,
 * Faculty of Science and Technology, University of Siegen, Germany
 * Winter Semester 2015/16  © 2015-2016 | All right reserved for University of Siegen
 */
package org.unisiegen.roc.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author RebellionPC
 *
 */
@Entity
@Table(name = "FEEDBACK_DETAILS")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FEEDBACK_ID", nullable = false)
    private long feedbackId;
    @Column(name = "FEEDBACK_TYPE", nullable = false)
    private int feedbackType;
    @Column(name = "SUBJECT", nullable = false)
    private String subject;
    @Column(name = "COMMENTS", nullable = false)
    private String comments;
    @Column(name = "FEEDBACK_DATE", nullable = false)
    private Date feedbackDate;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "MODEL_ID", nullable = false)
    private Model model;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "PRIORITY_ID", nullable = false)
    private Priority priority;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ISSUE_ID", nullable = false)
    private Issue issue;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "STATUS_ID", nullable = false)
    private Status status;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "RESOLVING_TEAM_ID", nullable = false)
    private ResolvingTeam resolvingTeam;

    /**
     *
     */
    public Feedback() {
    }

    /**
     * @return the feedbackId
     */
    public long getFeedbackId() {
        return feedbackId;
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
    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    /**
     * @param feedbackId the feedbackId to set
     */
    public void setFeedbackId(long feedbackId) {
        this.feedbackId = feedbackId;
    }

    /**
     * @return the feedbackType
     */
    public int getFeedbackType() {
        return feedbackType;
    }

    /**
     * @param feedbackType the feedbackType to set
     */
    public void setFeedbackType(int feedbackType) {
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
    public void setSubject(String subject) {
        this.subject = subject;
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
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the model
     */
    public Model getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * @return the priority
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * @return the issue
     */
    public Issue getIssue() {
        return issue;
    }

    /**
     * @param issue the issue to set
     */
    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the resolvingTeam
     */
    public ResolvingTeam getResolvingTeam() {
        return resolvingTeam;
    }

    /**
     * @param resolvingTeam the resolvingTeam to set
     */
    public void setResolvingTeam(ResolvingTeam resolvingTeam) {
        this.resolvingTeam = resolvingTeam;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((comments == null) ? 0 : comments.hashCode());
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
        result = prime * result + (int) (feedbackId ^ (feedbackId >>> 32));
        result = prime * result + feedbackType;
        result = prime * result + ((issue == null) ? 0 : issue.hashCode());
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + ((priority == null) ? 0 : priority.hashCode());
        result = prime * result + ((resolvingTeam == null) ? 0 : resolvingTeam.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((subject == null) ? 0 : subject.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
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
        Feedback other = (Feedback) obj;
        if (comments == null) {
            if (other.comments != null) {
                return false;
            }
        } else if (!comments.equals(other.comments)) {
            return false;
        }
        if (customer == null) {
            if (other.customer != null) {
                return false;
            }
        } else if (!customer.equals(other.customer)) {
            return false;
        }
        if (feedbackId != other.feedbackId) {
            return false;
        }
        if (feedbackType != other.feedbackType) {
            return false;
        }
        if (issue == null) {
            if (other.issue != null) {
                return false;
            }
        } else if (!issue.equals(other.issue)) {
            return false;
        }
        if (model == null) {
            if (other.model != null) {
                return false;
            }
        } else if (!model.equals(other.model)) {
            return false;
        }
        if (priority == null) {
            if (other.priority != null) {
                return false;
            }
        } else if (!priority.equals(other.priority)) {
            return false;
        }
        if (resolvingTeam == null) {
            if (other.resolvingTeam != null) {
                return false;
            }
        } else if (!resolvingTeam.equals(other.resolvingTeam)) {
            return false;
        }
        if (status == null) {
            if (other.status != null) {
                return false;
            }
        } else if (!status.equals(other.status)) {
            return false;
        }
        if (subject == null) {
            if (other.subject != null) {
                return false;
            }
        } else if (!subject.equals(other.subject)) {
            return false;
        }
        if (user == null) {
            if (other.user != null) {
                return false;
            }
        } else if (!user.equals(other.user)) {
            return false;
        }
        return true;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Feedback [feedbackId=" + feedbackId + ", feedbackType=" + feedbackType + ", subject=" + subject
                + ", comments=" + comments + ", user=" + user + ", customer=" + customer + ", model=" + model
                + ", priority=" + priority + ", issue=" + issue + ", status=" + status + ", resolvingTeam="
                + resolvingTeam + "]";
    }

    /**
     * @param feedbackId
     * @param feedbackType
     * @param subject
     * @param comments
     * @param user
     * @param customer
     * @param model
     * @param priority
     * @param issue
     * @param status
     * @param resolvingTeam
     */
    public Feedback(long feedbackId, int feedbackType, String subject, String comments, User user, Customer customer,
            Model model, Priority priority, Issue issue, Status status, ResolvingTeam resolvingTeam) {
        super();
        this.feedbackId = feedbackId;
        this.feedbackType = feedbackType;
        this.subject = subject;
        this.comments = comments;
        this.user = user;
        this.customer = customer;
        this.model = model;
        this.priority = priority;
        this.issue = issue;
        this.status = status;
        this.resolvingTeam = resolvingTeam;
    }

}
