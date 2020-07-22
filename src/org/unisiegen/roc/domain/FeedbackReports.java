/* 
 * Institute of Knowledge Based Systems and Knowledge Management,
 * Department of Electrical Engineering and Computer Science,
 * Faculty of Science and Technology, University of Siegen, Germany
 * Winter Semester 2015/16  © 2015-2016 | All right reserved for University of Siegen
 */
package org.unisiegen.roc.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author RebellionPC
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FeedbackReports {

    /**
     *
     */
    public FeedbackReports() {
    }

    @XmlElement
    private List<FeedbackReport> feedbacks = null;

    /**
     * @return the feedbacks
     */
    public List<FeedbackReport> getFeedbacks() {
        return feedbacks;
    }

    /**
     * @param feedbacks the feedbacks to set
     */
    public void setFeedbacks(List<FeedbackReport> feedbacks) {
        this.feedbacks = feedbacks;
    }

}
