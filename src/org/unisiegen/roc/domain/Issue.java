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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author RebellionPC
 *
 */
@Entity
@Table(name = "ISSUE")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ISSUE_ID", nullable = false)
    private int issueId;
    @Column(name = "ISSUE_NAME", nullable = false)
    private String issueName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "ISSUE_RESOLVINGTEAM", joinColumns = {
        @JoinColumn(name = "ISSUE_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "RESOLVING_TEAM_ID", nullable = false, updatable = false)})
    private List<ResolvingTeam> teamList = new ArrayList<ResolvingTeam>();

    @OneToMany(mappedBy = "issue", cascade = {CascadeType.ALL})
    private List<Feedback> feedbackList = new ArrayList<Feedback>();

    /**
     *
     */
    public Issue() {
    }

    /**
     * @return the issueId
     */
    public int getIssueId() {
        return issueId;
    }

    /**
     * @param issueId the issueId to set
     */
    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    /**
     * @return the issueName
     */
    public String getIssueName() {
        return issueName;
    }

    /**
     * @param issueName the issueName to set
     */
    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    /**
     * @return the teamList
     */
    public List<ResolvingTeam> getTeamList() {
        return teamList;
    }

    /**
     * @param teamList the teamList to set
     */
    public void setTeamList(List<ResolvingTeam> teamList) {
        this.teamList = teamList;
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
        result = prime * result + issueId;
        result = prime * result + ((issueName == null) ? 0 : issueName.hashCode());
        result = prime * result + ((teamList == null) ? 0 : teamList.hashCode());
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
        Issue other = (Issue) obj;
        if (feedbackList == null) {
            if (other.feedbackList != null) {
                return false;
            }
        } else if (!feedbackList.equals(other.feedbackList)) {
            return false;
        }
        if (issueId != other.issueId) {
            return false;
        }
        if (issueName == null) {
            if (other.issueName != null) {
                return false;
            }
        } else if (!issueName.equals(other.issueName)) {
            return false;
        }
        if (teamList == null) {
            if (other.teamList != null) {
                return false;
            }
        } else if (!teamList.equals(other.teamList)) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Issue [issueId=" + issueId + ", issueName=" + issueName + ", teamList=" + teamList + ", feedbackList="
                + feedbackList + "]";
    }

    /**
     * @param issueId
     * @param issueName
     * @param teamList
     * @param feedbackList
     */
    public Issue(int issueId, String issueName, List<ResolvingTeam> teamList, List<Feedback> feedbackList) {
        super();
        this.issueId = issueId;
        this.issueName = issueName;
        this.teamList = teamList;
        this.feedbackList = feedbackList;
    }

}
