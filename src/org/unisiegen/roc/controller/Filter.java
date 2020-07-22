/* 
 * Institute of Knowledge Based Systems and Knowledge Management,
 * Department of Electrical Engineering and Computer Science,
 * Faculty of Science and Technology, University of Siegen, Germany
 * Winter Semester 2015/16  © 2015-2016 | All right reserved for University of Siegen
 */
package org.unisiegen.roc.controller;

import java.util.Date;
import org.unisiegen.roc.domain.Priority;
import org.unisiegen.roc.domain.ResolvingTeam;
import org.unisiegen.roc.domain.Status;

/**
 * Class to encapsulate different filter criteria.
 * @author Pratik
 */
public class Filter {

    public Filter() {

    }

    public void setPriorityFilter(Priority priorityItem) {
        this.priorityFilter = priorityItem;
    }

    public Priority getPriorityFilter() {
        return this.priorityFilter;
    }

    public void setStatusFilter(Status statusItem) {
        this.statusFilter = statusItem;
    }

    public Status getStatusFilter() {
        return this.statusFilter;
    }

    public void setTeamFilter(ResolvingTeam teamItem) {
        this.teamFilter = teamItem;
    }

    public ResolvingTeam getTeamFilter() {
        return this.teamFilter;
    }

    public void setStartDateFilter(Date dateItem) {
        this.startDate = dateItem;
    }

    public Date getStartDateFilter() {
        return this.startDate;
    }

    public void setEndDateFilter(Date dateItem) {
        this.endDate = dateItem;
    }

    public Date getEndDateFilter() {
        return this.endDate;
    }

    public void setPeriodFilter(int periodItem) {
        this.timePeriod = periodItem;
    }

    public int getPeriodFilter() {
        return this.timePeriod;
    }

    private Priority priorityFilter;
    private Status statusFilter;
    private ResolvingTeam teamFilter;
    private Date startDate;
    private Date endDate;
    private int timePeriod;
}
