/**
 * 
 */
package org.unisiegen.roc.dao;

import java.util.HashMap;
import java.util.List;
import org.unisiegen.roc.controller.Filter;

import org.unisiegen.roc.domain.Customer;
import org.unisiegen.roc.domain.Feedback;
import org.unisiegen.roc.domain.Issue;
import org.unisiegen.roc.domain.Model;
import org.unisiegen.roc.domain.Priority;
import org.unisiegen.roc.domain.Product;
import org.unisiegen.roc.domain.ResolvingTeam;
import org.unisiegen.roc.domain.Status;
import org.unisiegen.roc.domain.User;
import org.unisiegen.roc.exception.DaoException;

/**
 * @author RebellionPC
 *
 */
public interface RocDao {
    //Function to insert feedback details in student table
    public long insertFeedbackDetails(Feedback feedback) throws DaoException;
    //Function to update feedback details in student table
    public void updateFeedbackDetails(Feedback feedback) throws DaoException;
    //Function to get feedback details depending on the matriculation number
    public Feedback getFeedbackDetailsById(long feedbackId) throws DaoException;
    //Function to get feedback by userID from the student table
    public List<Feedback> getFeedbackByUserId(User user) throws DaoException;
    //Function to get all feedback records from database
    public List<Feedback> getAllFeedbackDetails() throws DaoException;
    //Function to validate login credentials
    public boolean validateUserCredentials(User user) throws DaoException;
    //Function to get list of all products
    public List<Product> getAllProducts() throws DaoException;
    //Function to get all the models for a particular product
    public List<Model> getAllModelByProduct(Product product) throws DaoException;
    //Function to get list of all issues for the robot
    public List<Issue> getAllIssues() throws DaoException;
    //Function to get all the resolving team by issue
    public List<ResolvingTeam> getAllResolvingTeamByIssue(Issue issue) throws DaoException;
    //Function to get the list of all priorities
    public List<Priority> getAllPriorty() throws DaoException;
    // Funstion to get list of all the status
    public List<Status> getAllStatus() throws DaoException;
    // Funstion to get list of all the resolving team
    public List<ResolvingTeam> getAllResolvingTeam() throws DaoException;
    //Function to get count of feedback by priority
    public HashMap<String, Long> getFeedbackCountByPriority() throws DaoException;
    //Function to get list of all critical feedbacks
    public List<Feedback> getCriticalFeedbacks() throws DaoException;    
    //Function to get feedback details as per filter criteria
    public List<Feedback> getFeedbackByFilterCriteria(Filter filterCriteria) throws DaoException;
}
