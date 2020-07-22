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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author RebellionPC
 *
 */
@Entity
@Table(name = "RESOLVING_TEAM")
public class ResolvingTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESOLVING_TEAM_ID", nullable = false)
    private int teamId;
    @Column(name = "TEAM_DESCRIPTION", nullable = false)
    private String teamDescription;
    @Column(name = "EMAIL_ADDRESS", nullable = false)
    private String emailAddress;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "teamList")
    private List<Issue> issueList = new ArrayList<Issue>();

    @OneToMany(mappedBy = "resolvingTeam", cascade = {CascadeType.ALL})
    private List<Feedback> feedbackList = new ArrayList<Feedback>();

    /**
     *
     */
    public ResolvingTeam() {
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the teamId
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * @param teamId the teamId to set
     */
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    /**
     * @return the teamDescription
     */
    public String getTeamDescription() {
        return teamDescription;
    }

    /**
     * @param teamDescription the teamDescription to set
     */
    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }

    /**
     * @return the issueList
     */
    public List<Issue> getIssueList() {
        return issueList;
    }

    /**
     * @param issueList the issueList to set
     */
    public void setIssueList(List<Issue> issueList) {
        this.issueList = issueList;
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
        result = prime * result + ((issueList == null) ? 0 : issueList.hashCode());
        result = prime * result + ((teamDescription == null) ? 0 : teamDescription.hashCode());
        result = prime * result + teamId;
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
        ResolvingTeam other = (ResolvingTeam) obj;
        if (feedbackList == null) {
            if (other.feedbackList != null) {
                return false;
            }
        } else if (!feedbackList.equals(other.feedbackList)) {
            return false;
        }
        if (issueList == null) {
            if (other.issueList != null) {
                return false;
            }
        } else if (!issueList.equals(other.issueList)) {
            return false;
        }
        if (teamDescription == null) {
            if (other.teamDescription != null) {
                return false;
            }
        } else if (!teamDescription.equals(other.teamDescription)) {
            return false;
        }
        if (teamId != other.teamId) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ResolvingTeam [teamId=" + teamId + ", teamDescription=" + teamDescription + ", issueList=" + issueList
                + ", feedbackList=" + feedbackList + "]";
    }

    /**
     * @param teamId
     * @param teamDescription
     * @param issueList
     * @param feedbackList
     */
    public ResolvingTeam(int teamId, String teamDescription, List<Issue> issueList, List<Feedback> feedbackList) {
        super();
        this.teamId = teamId;
        this.teamDescription = teamDescription;
        this.issueList = issueList;
        this.feedbackList = feedbackList;
    }

}
