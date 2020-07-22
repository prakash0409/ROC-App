/* 
 * Institute of Knowledge Based Systems and Knowledge Management,
 * Department of Electrical Engineering and Computer Science,
 * Faculty of Science and Technology, University of Siegen, Germany
 * Winter Semester 2015/16  © 2015-2016 | All right reserved for University of Siegen
 */
package org.unisiegen.roc.dao.hibernate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.unisiegen.roc.controller.Filter;

import org.unisiegen.roc.dao.RocDao;
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
public class RocDaoJdbcImpl implements RocDao {

    public RocDaoJdbcImpl() throws DaoException {
        super();
    }

    @Override
    public long insertFeedbackDetails(Feedback feedback) throws DaoException {
        Session session = null;
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Model model = session.load(Model.class, feedback.getModel().getModelId());
            Product product = session.load(Product.class, feedback.getModel().getProduct().getProductId());
            //Customer customer = session.get(Customer.class, feedback.getCustomer().getCustomerId());
            User user = session.load(User.class, feedback.getUser().getUserId());
            Issue issue = session.load(Issue.class, feedback.getIssue().getIssueId());
            Priority priority = session.load(Priority.class, feedback.getPriority().getPriorityId());
            Status status = session.load(Status.class, feedback.getStatus().getStatusId());
            ResolvingTeam resolvingTeam = session.load(ResolvingTeam.class, feedback.getResolvingTeam().getTeamId());
            model.setProduct(product);
            //feedback.setCustomer(customer);
            feedback.setUser(user);
            feedback.setIssue(issue);
            feedback.setPriority(priority);
            feedback.setStatus(status);
            feedback.setModel(model);
            feedback.setResolvingTeam(resolvingTeam);
            session.saveOrUpdate(feedback);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw new DaoException(e.getMessage(), e);
        }
        return feedback.getFeedbackId();
    }

    @Override
    public void updateFeedbackDetails(Feedback feedback) throws DaoException {
        Session session = null;
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(feedback);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Feedback getFeedbackDetailsById(long feedbackId) throws DaoException {
        Session session = null;
        Feedback feedback = null;
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("select f from Feedback f where f.feedbackId = ?");
            query.setLong(0, feedbackId);
            feedback = (Feedback) query.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        } finally {
            session.close();
        }
        return feedback;
    }

    @Override
    public List<Feedback> getFeedbackByUserId(User user) throws DaoException {
        Session session = null;
        List<Feedback> feedbackList = new ArrayList<>();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("select f from Feedback f join f.user u where u.userId = ?");
            query.setInteger(0, user.getUserId());
            feedbackList = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        } finally {
            session.close();            
        }
        return feedbackList;
    }

    @Override
    public List<Feedback> getAllFeedbackDetails() throws DaoException {
        Session session = null;
        List<Feedback> feedbackList = new ArrayList<>();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("select f from Feedback f");
            feedbackList = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        } finally {
            session.close();
        }
        return feedbackList;
    }

    @Override
    public boolean validateUserCredentials(User user) throws DaoException {
        Session session = null;
        Boolean loginValidate = false;
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("select u from User u where u.userName=?");
            query.setString(0, user.getUserName());
            User userDBResult = (User) query.uniqueResult();
            if (userDBResult != null && user.getUserName().equals(userDBResult.getUserName()) && user.getPassword().equals(userDBResult.getPassword())) {
                loginValidate = true;
                user.setFirstName(userDBResult.getFirstName());
                user.setLastName(userDBResult.getLastName());
                user.setUserId(userDBResult.getUserId());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        } finally {
            session.close();
        }
        return loginValidate;
    }

    @Override
    public List<Product> getAllProducts() throws DaoException {
        Session session = null;
        List<Product> productList = new ArrayList<>();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("select p from Product p");
            productList = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        } finally {
            session.close();
        }
        return productList;
    }

    @Override
    public List<Model> getAllModelByProduct(Product product) throws DaoException {
        Session session = null;
        List<Model> modelList = new ArrayList<>();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("select m from Product p join p.modelList m where p.productId =?");
            query.setInteger(0, product.getProductId());
            modelList = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        } finally {
            session.close();
        }
        return modelList;
    }

    @Override
    public List<Issue> getAllIssues() throws DaoException {
        Session session = null;
        List<Issue> issueList = new ArrayList<>();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("select i from Issue i");
            issueList = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        } finally {
            session.close();
        }
        return issueList;
    }

    @Override
    public List<ResolvingTeam> getAllResolvingTeamByIssue(Issue issue) throws DaoException {
        Session session = null;
        List<ResolvingTeam> resolvingTeamList = new ArrayList<>();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("select t from Issue i join i.teamList t where i.issueId =?");
            query.setInteger(0, issue.getIssueId());
            resolvingTeamList = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        } finally {
            session.close();
        }
        return resolvingTeamList;
    }

    @Override
    public List<Priority> getAllPriorty() throws DaoException {
        Session session = null;
        List<Priority> priorityList = new ArrayList<>();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("select p from Priority p");
            priorityList = (List<Priority>) query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        } finally {
            session.close();
        }
        return priorityList;
    }

    @Override
    public List<Status> getAllStatus() throws DaoException {
        Session session = null;
        List<Status> statusList = new ArrayList<>();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("select s from Status s");
            statusList = (List<Status>) query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        } finally {
            session.close();
        }
        return statusList;
    }

    @Override
    public List<ResolvingTeam> getAllResolvingTeam() throws DaoException {
        Session session = null;
        List<ResolvingTeam> teamList = new ArrayList<>();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("select t from ResolvingTeam t");
            teamList = (List<ResolvingTeam>) query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        } finally {
            session.close();
        }
        return teamList;
    }

    @Override
    public HashMap<String, Long> getFeedbackCountByPriority() throws DaoException {
        Session session = null;
        HashMap<String, Long> feedbackPriorityCountMap = new HashMap<String, Long>();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("select p.priorityName,count(p.priorityId) as priorityCount from Feedback f join f.priority p join f.status s where s.statusDescription != 'Resolved' group by p.priorityId");
            List<Object[]> resultList = query.list();
            for (Object[] result : resultList) {
                feedbackPriorityCountMap.put((String) result[0], (Long) result[1]);
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        } finally {
            session.close();
        }
        return feedbackPriorityCountMap;
    }

    @Override
    public List<Feedback> getCriticalFeedbacks() throws DaoException {
        Session session = null;
        List<Feedback> feedbackList = new ArrayList<Feedback>();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("select f  from Feedback f join f.priority p join f.status s where p.priorityName = 'Critical' and (s.statusDescription = 'Work In Progress' or s.statusDescription = 'Pending') ");
            feedbackList = (List<Feedback>) query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        } finally {
            session.close();
        }
        return feedbackList;
    }
    
    @Override
    public List<Feedback> getFeedbackByFilterCriteria(Filter filterCriteria) throws DaoException {
        Session session = null;
        List<Feedback> feedbackList = new ArrayList<>();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            String filterQuery = "select f from Feedback f join f.priority p join f.status s join f.resolvingTeam r where ";
            int i = 0, j = 0;
            Priority priority = filterCriteria.getPriorityFilter();
            Status status = filterCriteria.getStatusFilter();
            ResolvingTeam resolvingTeam = filterCriteria.getTeamFilter();
            Date startDate = filterCriteria.getStartDateFilter();
            Date endDate = filterCriteria.getEndDateFilter();
            int timePeriod = filterCriteria.getPeriodFilter();

            if (priority != null) {
                filterQuery += "p.priorityId = ?";
                j++;
            }
            if (status != null) {
                if (j > 0) {
                    filterQuery += " and s.statusId = ?";
                } else {
                    filterQuery += " s.statusId = ?";
                }
                j++;

            }
            if (resolvingTeam != null) {
                if (j > 0) {
                    filterQuery += " and r.teamId = ?";
                } else {
                    filterQuery += " r.teamId = ?";
                }
                j++;
            }
            if ((startDate != null && endDate != null) || timePeriod != 0) {
                if (j > 0) {
                    filterQuery += " and f.feedbackDate BETWEEN ? and ?";
                } else {
                    filterQuery += " f.feedbackDate BETWEEN  ? and ?";
                }
            }

            Query query = session.createQuery(filterQuery);

            if (priority != null) {
                query.setInteger(i++, priority.getPriorityId());
            }
            if (status != null) {
                query.setInteger(i++, status.getStatusId());
            }
            if (resolvingTeam != null) {
                query.setInteger(i++, resolvingTeam.getTeamId());
            }
            if ((startDate != null && endDate != null) || timePeriod != 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String formattedStartDate = "";
                String formattedEndDate = "";
                Calendar c = Calendar.getInstance();
                if (timePeriod != 0) {
                    c.setTime(new java.util.Date());
                    c.add(Calendar.MONTH, (-timePeriod));
                    formattedStartDate = sdf.format(c.getTime());
                    c.setTime(new java.util.Date());
                    c.add(Calendar.DATE, 1);
                    formattedEndDate = sdf.format(c.getTime());
                } else {
                    c.setTime(endDate);
                    c.add(Calendar.DATE, 1);
                    formattedEndDate = sdf.format(c.getTime());
                    formattedStartDate = sdf.format(startDate);
                }

                query.setString(i++, formattedStartDate);
                query.setString(i++, formattedEndDate);
            }

            feedbackList = (List<Feedback>) query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new DaoException(e.getMessage(), e);
        } finally {
            session.close();
        }

        return feedbackList;
    }
}
