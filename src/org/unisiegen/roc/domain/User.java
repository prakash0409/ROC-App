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
@Table(name = "USER_DETAILS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private int userId;
    @Column(name = "USER_NAME", nullable = false)
    private String userName;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    List<Feedback> feedbackList = new ArrayList<Feedback>();

    /**
     *
     */
    public User() {
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + userId;
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
        User other = (User) obj;
        if (feedbackList == null) {
            if (other.feedbackList != null) {
                return false;
            }
        } else if (!feedbackList.equals(other.feedbackList)) {
            return false;
        }
        if (firstName == null) {
            if (other.firstName != null) {
                return false;
            }
        } else if (!firstName.equals(other.firstName)) {
            return false;
        }
        if (lastName == null) {
            if (other.lastName != null) {
                return false;
            }
        } else if (!lastName.equals(other.lastName)) {
            return false;
        }
        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }
        if (userId != other.userId) {
            return false;
        }
        if (userName == null) {
            if (other.userName != null) {
                return false;
            }
        } else if (!userName.equals(other.userName)) {
            return false;
        }
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", firstName="
                + firstName + ", lastName=" + lastName + ", feedbackList=" + feedbackList + "]";
    }

    /**
     * @param userId
     * @param userName
     * @param password
     * @param firstName
     * @param lastName
     * @param feedbackList
     */
    public User(int userId, String userName, String password, String firstName, String lastName,
            List<Feedback> feedbackList) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.feedbackList = feedbackList;
    }

}
