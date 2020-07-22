/* 
 * Institute of Knowledge Based Systems and Knowledge Management,
 * Department of Electrical Engineering and Computer Science,
 * Faculty of Science and Technology, University of Siegen, Germany
 * Winter Semester 2015/16  © 2015-2016 | All right reserved for University of Siegen
 */
package org.unisiegen.roc.controller;

import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.util.List;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.xml.transform.TransformerException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import org.apache.fop.apps.FOPException;
import org.unisiegen.roc.dao.DaoFactory;
import org.unisiegen.roc.dao.RocDao;
import org.unisiegen.roc.domain.Email;
import org.unisiegen.roc.domain.Feedback;
import org.unisiegen.roc.domain.Issue;
import org.unisiegen.roc.domain.Model;
import org.unisiegen.roc.domain.Priority;
import org.unisiegen.roc.domain.Product;
import org.unisiegen.roc.domain.ResolvingTeam;
import org.unisiegen.roc.domain.Status;
import org.unisiegen.roc.domain.User;
import org.unisiegen.roc.email.SendEmail;
import org.unisiegen.roc.exception.DaoException;
import org.unisiegen.roc.exception.RocException;
import org.unisiegen.roc.report.FeedbackReportPDF;
import org.unisiegen.roc.report.FeedbackReportXLS;
import org.unisiegen.roc.view.frames.subframes.LoginScreen;
import org.unisiegen.roc.view.frames.subframes.MainMenuScreen;
import org.unisiegen.roc.view.frames.subframes.ReportScreen;
import org.unisiegen.roc.view.frames.subframes.UpdateWorkOrderScreen;
import org.unisiegen.roc.view.frames.subframes.WorkOrderConfirmScreen;
import org.unisiegen.roc.view.frames.subframes.WorkOrderScreen;
import org.unisiegen.roc.view.frames.MasterScreen;

/**
 * Controller acts like VIEW to form interfacing logical layer between database
 * and user interface.
 *
 * @author Pratik
 */
public class MainController {

    // <editor-fold desc="Constructors">
    public MainController() {
        try {
            this.rocDao = DaoFactory.getRocDaoInstance();
        } catch (DaoException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // </editor-fold>
    // <editor-fold desc="Public Methods">
    /**
     * Method to validate user credentials.
     *
     * @param user - User object containing information about user to login the
     * application
     * @return Validity of user credentials
     * @throws org.unisiegen.roc.exception.RocException
     */
    public boolean validateUser(User user) throws RocException {
        boolean isValid = false;
        try {
            isValid = rocDao.validateUserCredentials(user);
        } catch (DaoException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RocException(ex.getMessage(), ex);
        }

        return isValid;
    }

    /**
     * Method to remove internal frame decoration.
     *
     * @param frame - The internal frame of which decoration is to be removed
     */
    public void removeInternalFrameDecoration(JInternalFrame frame) {
        BasicInternalFrameUI ui = (BasicInternalFrameUI) frame.getUI();
        Container box = (Container) ui.getNorthPane();
        box.remove(0);
        box.validate();
        box.repaint();
    }

    /**
     * Method to add appropriate internal frame to desktop pane based on user
     * interaction.
     *
     * @param pane - Desktop pane to which internal frame is to be added
     * @param frameName - Name of internal frame to be added
     */
    public void addFrameToPane(JDesktopPane pane, String frameName) {
        JInternalFrame frame = null;
        if (frameName != null && !frameName.isEmpty()) {
            switch (frameName) {
                case "LoginScreen":
                    frame = new LoginScreen();
                    MasterScreen.loggingBarActivate(false, null);
                    break;

                case "MainMenuScreen":
                    frame = new MainMenuScreen();
                    break;

                case "ReportScreen":
                    frame = new ReportScreen();
                    break;

                case "UpdateWorkOrderScreen":
                    frame = new UpdateWorkOrderScreen();
                    break;

                case "WorkOrderConfirmScreen":
                    frame = new WorkOrderConfirmScreen();
                    break;

                case "WorkOrderScreen":
                    frame = new WorkOrderScreen();
                    break;
            }
        }

        setFrameToPane(frame, pane, frameName);
    }

    /**
     * Method to change user flow to the order confirmation screen.
     *
     * @param pane - Desktop pane to which internal frame is to be added
     * @param order - Feedback order to be moved for confirmation
     */
    public void moveToOrderConfirmation(JDesktopPane pane, Feedback order) {
        WorkOrderConfirmScreen frame = new WorkOrderConfirmScreen();
        this.setFrameToPane(frame, pane, "WorkOrderConfirmScreen");
        frame.populateOrderDetails(order);
    }

    /**
     * Method to change user flow to the order editing section.
     *
     * @param pane - Desktop pane to which internal frame is to be added
     * @param order - Feedback order to be moved for editing
     */
    public void moveToOrderEdit(JDesktopPane pane, Feedback order) {
        WorkOrderScreen frame = new WorkOrderScreen();
        this.setFrameToPane(frame, pane, "WorkOrderScreen");
        frame.populateEditOrderDetails(order);
    }

    /**
     * Method to change user flow to the order updating section.
     *
     * @param pane - Desktop pane to which internal frame is to be added
     * @param order - Feedback order to be moved for updating
     */
    public void moveToOrderUpdate(JDesktopPane pane, Feedback order) {
        WorkOrderScreen frame = new WorkOrderScreen();
        this.setFrameToPane(frame, pane, "WorkOrderScreen");
        frame.setUpdate(true);
        frame.populateEditOrderDetails(order);
    }

    /**
     * Method to change user flow to the order viewing section.
     *
     * @param pane - Desktop pane to which internal frame is to be added
     * @param order - Feedback order to be moved for updating
     */
    public void moveToOrderView(JDesktopPane pane, Feedback order) {
        WorkOrderConfirmScreen frame = new WorkOrderConfirmScreen();
        this.setFrameToPane(frame, pane, "WorkOrderConfirmScreen");
        frame.setView(true);
        frame.populateOrderDetails(order);
    }

    /**
     * Method to change user flow to critical order reporting.
     *
     * @param pane - Desktop pane to which internal frame is to be added
     * @throws org.unisiegen.roc.exception.RocException
     */
    public void moveToCriticalReports(JDesktopPane pane) throws RocException {
        ReportScreen frame = new ReportScreen();
        this.setFrameToPane(frame, pane, "ReportScreen");
        CustomComboItem criticalItem = null;
        List<Priority> priorityList = null;
        try {
            priorityList = rocDao.getAllPriorty();
        } catch (DaoException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RocException(ex.getMessage(), ex);
        }
        if (priorityList != null && !priorityList.isEmpty()) {
            for (Priority item : priorityList) {
                criticalItem = (item.getPriorityName().equals("Critical")) ? new CustomComboItem(item.getPriorityName(), item.getPriorityId()) : null;
                if (criticalItem != null) {
                    break;
                }
            }
        }
        frame.configureForCriticalReport(criticalItem);
    }

    /**
     * Method to search feedback details by given order ID.
     *
     * @param id - Feedback order ID
     * @param table - Table to which results are populated
     * @return Result of search
     * @throws org.unisiegen.roc.exception.RocException
     */
    public boolean searchFeedbackDetailsById(long id, JTable table) throws RocException {
        this.searchValid = false;
        this.searchId = id;
        try {
            this.populateTable(table, "Search", null);
            if (!this.searchValid) {
                this.populateTable(table, "Standard", null);
            }
        } catch (RocException ex) {
            throw new RocException(ex.getMessage(), ex);
        }

        return searchValid;
    }

    /**
     * Method to fill up the drop boxes of the application.
     *
     * @param box - Drop box to be populated with data
     * @param boxType - Type or name of the box to be populated with data
     * @throws org.unisiegen.roc.exception.RocException
     */
    public void populateDropDown(JComboBox box, String boxType) throws RocException {
        if (box != null && boxType != null && !boxType.isEmpty()) {
            box.removeAllItems();
            switch (boxType) {
                case "ProductBox": {
                    try {
                        List<Product> productList = rocDao.getAllProducts();
                        if (productList != null && !productList.isEmpty()) {
                            productList.stream().forEach((productInfo) -> {
                                box.addItem(new CustomComboItem(productInfo.getProductName(), productInfo.getProductId()));
                            });
                        }
                    } catch (DaoException ex) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                        throw new RocException(ex.getMessage(), ex);
                    }
                }
                break;

                case "IssueBox": {
                    try {
                        List<Issue> issueList = rocDao.getAllIssues();
                        if (issueList != null && !issueList.isEmpty()) {
                            issueList.stream().forEach((issueInfo) -> {
                                box.addItem(new CustomComboItem(issueInfo.getIssueName(), issueInfo.getIssueId()));
                            });
                        }
                    } catch (DaoException ex) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                        throw new RocException(ex.getMessage(), ex);
                    }
                }
                break;

                case "PriorityBox": {
                    try {
                        List<Priority> priorityList = rocDao.getAllPriorty();
                        if (priorityList != null && !priorityList.isEmpty()) {
                            priorityList.stream().forEach((priorityInfo) -> {
                                box.addItem(new CustomComboItem(priorityInfo.getPriorityName(), priorityInfo.getPriorityId()));
                            });
                        }
                    } catch (DaoException ex) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                        throw new RocException(ex.getMessage(), ex);
                    }
                }
                break;

                case "StatusBox": {
                    try {
                        List<Status> statusList = rocDao.getAllStatus();
                        if (statusList != null && !statusList.isEmpty()) {
                            statusList.stream().forEach((statusInfo) -> {
                                box.addItem(new CustomComboItem(statusInfo.getStatusDescription(), statusInfo.getStatusId()));
                            });
                        }
                    } catch (DaoException ex) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                        throw new RocException(ex.getMessage(), ex);
                    }
                }
                break;

                case "TeamBox": {
                    try {
                        List<ResolvingTeam> teamList = rocDao.getAllResolvingTeam();
                        if (teamList != null && !teamList.isEmpty()) {
                            teamList.stream().forEach((teamInfo) -> {
                                box.addItem(new CustomComboItem(teamInfo.getTeamDescription(), teamInfo.getTeamId()));
                            });
                        }
                    } catch (DaoException ex) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                        throw new RocException(ex.getMessage(), ex);
                    }
                }
                break;

                case "PeriodBox": {
                    box.addItem(new CustomComboItem("Current Month", 1));
                    box.addItem(new CustomComboItem("2 months", 2));
                    box.addItem(new CustomComboItem("3 months", 3));
                    box.addItem(new CustomComboItem("4 months", 4));
                    box.addItem(new CustomComboItem("5 months", 5));
                    box.addItem(new CustomComboItem("6 months", 6));
                }
                break;

                case "ReportBox": {
                    box.addItem(new CustomComboItem("Summarised Format", 1));
                    box.addItem(new CustomComboItem("Detailed Version", 2));
                }
                break;
            }
        }
    }

    /**
     * Method to fill up the table result sets of the application.
     *
     * @param table - Table to populate with data
     * @param viewType - Type of table view
     * @param filter - Filter parameters for data population in table
     * @return Feedback collection result set
     * @throws org.unisiegen.roc.exception.RocException
     */
    public List<Feedback> populateTable(JTable table, String viewType, Filter filter) throws RocException {
        List<Feedback> feedbackCollection = null;
        try {
            if (table != null && viewType != null && !viewType.isEmpty()) {
                JCheckBox checkBox = new JCheckBox();
                ButtonGroup boxGroup = new ButtonGroup();
                boxGroup.add(checkBox);
                TableColumn columnModel = table.getColumnModel().getColumn(0);
                columnModel.setCellEditor(new DefaultCellEditor(checkBox));
                switch (viewType) {
                    case "Standard":
                        feedbackCollection = this.getFeedbackCollection();
                        break;

                    case "Update":
                        List<Feedback> feedbackCollectionSource = this.getFeedbackCollection();
                        if (feedbackCollectionSource != null && !feedbackCollectionSource.isEmpty()) {
                            feedbackCollection = feedbackCollectionSource.stream().filter(item -> !item.getStatus().getStatusDescription().equals("Resolved")).collect(Collectors.toList());
                        }
                        break;

                    case "Critical":
                        feedbackCollection = this.getCriticalFeedbackCollection();
                        break;

                    case "Filter":
                        if (filter != null) {
                            feedbackCollection = this.getFeedbackCollectionByFilter(filter);
                        }
                        break;

                    case "Search":
                        feedbackCollection = this.getFeedbackCollectionBySearch(this.searchId);
                        this.searchValid = feedbackCollection != null && !feedbackCollection.isEmpty();
                        break;
                }

                Object[] columnNames = {"", "Order ID", "Subject", "Priority", "Team Assigned", "Status", "Date"};
                DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
                DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames) {
                    @Override
                    public Class getColumnClass(int col) {
                        return col == 0 ? Boolean.class : String.class;
                    }

                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return column == 0;
                    }
                };
                if (feedbackCollection != null && !feedbackCollection.isEmpty()) {
                    feedbackCollection.stream().map((Feedback feedbackItem) -> {
                        Object[] obj = new Object[7];
                        obj[0] = false;
                        obj[1] = feedbackItem.getFeedbackId();
                        obj[2] = feedbackItem.getSubject();
                        obj[3] = feedbackItem.getPriority().getPriorityName();
                        obj[4] = feedbackItem.getResolvingTeam().getTeamDescription();
                        obj[5] = feedbackItem.getStatus().getStatusDescription();
                        obj[6] = formatDate.format(feedbackItem.getFeedbackDate());
                        return obj;
                    }).forEach((obj) -> {
                        model.addRow(obj);
                    });
                }

                table.setModel(model);
            }
        } catch (RocException ex) {
            throw new RocException(ex.getMessage(), ex);
        }

        return feedbackCollection;
    }

    /**
     * Method to get Model collection based on product.
     *
     * @param product - Product based on which the model details are retrieved
     * @return List of model details
     * @throws org.unisiegen.roc.exception.RocException
     */
    public List<Model> getModelCollectionByProduct(Product product) throws RocException {
        List<Model> modelList = null;
        try {
            modelList = rocDao.getAllModelByProduct(product);
        } catch (DaoException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RocException(ex.getMessage(), ex);
        }

        return modelList;
    }

    /**
     * Method to get Product collection.
     *
     * @return List of products
     * @throws RocException
     */
    public List<Product> getProductCollection() throws RocException {
        List<Product> productList = null;
        try {
            productList = rocDao.getAllProducts();
        } catch (DaoException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RocException(ex.getMessage(), ex);
        }

        return productList;
    }

    /**
     * Method to get resolving team collection based on issue.
     *
     * @param issue - Issue based on which the team details are retrieved
     * @return List of resolving team details
     * @throws org.unisiegen.roc.exception.RocException
     */
    public List<ResolvingTeam> getTeamCollectionByIssue(Issue issue) throws RocException {
        List<ResolvingTeam> teamList = null;
        try {
            teamList = rocDao.getAllResolvingTeamByIssue(issue);
        } catch (DaoException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RocException(ex.getMessage(), ex);
        }

        return teamList;
    }

    /**
     * Method to insert feedback details to application database.
     *
     * @param feedback - Feedback to be inserted
     * @return Reference order ID
     * @throws org.unisiegen.roc.exception.RocException
     */
    public long submitFeedback(Feedback feedback) throws RocException {
        long referenceNumber = 0;
        try {
            referenceNumber = rocDao.insertFeedbackDetails(feedback);
        } catch (DaoException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RocException(ex.getMessage(), ex);
        }

        return referenceNumber;
    }

    /**
     * Method to get complete feedback collection.
     *
     * @return List of all feedback
     * @throws org.unisiegen.roc.exception.RocException
     */
    public List<Feedback> getFeedbackCollection() throws RocException {
        List<Feedback> feedbackList = null;
        try {
            feedbackList = rocDao.getAllFeedbackDetails();
        } catch (DaoException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RocException(ex.getMessage(), ex);
        }

        return feedbackList;
    }

    /**
     * Method to get all critical feedback orders.
     *
     * @return List of critical feedback orders
     * @throws org.unisiegen.roc.exception.RocException
     */
    public List<Feedback> getCriticalFeedbackCollection() throws RocException {
        List<Feedback> feedbackList = null;
        try {
            feedbackList = rocDao.getCriticalFeedbacks();
        } catch (DaoException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RocException(ex.getMessage(), ex);
        }

        return feedbackList;
    }

    /**
     * Method to get feedback collection based on filter parameters.
     *
     * @param filter - Filter parameters based on which feedback is retrieved
     * @return List of feedback orders based on filter criteria
     * @throws org.unisiegen.roc.exception.RocException
     */
    public List<Feedback> getFeedbackCollectionByFilter(Filter filter) throws RocException {
        List<Feedback> feedbackList = null;
        try {
            if (filter != null) {
                feedbackList = rocDao.getFeedbackByFilterCriteria(filter);
            }
        } catch (DaoException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RocException(ex.getMessage(), ex);
        }

        return feedbackList;
    }

    /**
     * Method to get feedback details as per search criteria.
     *
     * @param feedbackId - Feedback order ID on which search is performed
     * @return List of searched feedback order
     * @throws org.unisiegen.roc.exception.RocException
     */
    public List<Feedback> getFeedbackCollectionBySearch(long feedbackId) throws RocException {
        List<Feedback> feedbackList = null;
        try {
            feedbackList = new ArrayList<>();
            Feedback item = rocDao.getFeedbackDetailsById(feedbackId);
            if (item != null) {
                feedbackList.add(item);
            }
        } catch (DaoException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RocException(ex.getMessage(), ex);
        }

        return feedbackList;
    }

    /**
     * Method to get feedback collection count based on priority.
     *
     * @return Map of feedback orders
     * @throws org.unisiegen.roc.exception.RocException
     */
    public HashMap<String, Long> getFeedbackCollectionCountByPriority() throws RocException {
        HashMap<String, Long> feedbackCountMap = null;
        try {
            feedbackCountMap = rocDao.getFeedbackCountByPriority();
        } catch (DaoException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RocException(ex.getMessage(), ex);
        }

        return feedbackCountMap;
    }

    /**
     * Method to generate report in the PDF format file.
     *
     * @param feedbackList - List of those feedback that are to be displayed in
     * the report
     * @param formatType - The format type of the report
     * @throws org.unisiegen.roc.exception.RocException
     */
    public void generatePDFReport(List<Feedback> feedbackList, String formatType) throws RocException {
        if (feedbackList != null && !feedbackList.isEmpty() && formatType != null && !formatType.isEmpty()) {
            FeedbackReportPDF detailedFeedbackReport = new FeedbackReportPDF(feedbackList);
            try {
                detailedFeedbackReport.getReport(formatType);
                if (!isEmail) {
                    File myFile = new File("CustomerFeedbackReport.pdf");
                    Desktop.getDesktop().open(myFile);
                }
            } catch (FOPException | TransformerException | IOException e) {
                e.printStackTrace();
                throw new RocException(e.getMessage(), e);
            }
        }
    }

    /**
     * Method to generate report in the Excel format file.
     *
     * @param feedbackList - List of those feedback that are to be displayed in
     * the report
     * @param formatType - The format type of the report
     * @throws org.unisiegen.roc.exception.RocException
     */
    public void generateExcelReport(List<Feedback> feedbackList, String formatType) throws RocException {
        if (feedbackList != null && !feedbackList.isEmpty() && formatType != null && !formatType.isEmpty()) {
            FeedbackReportXLS customerFeedbackReport = new FeedbackReportXLS(feedbackList);
            try {
                JasperPrint jp = customerFeedbackReport.getReport(formatType);
                JRXlsExporter xlsExporter = new JRXlsExporter();
                xlsExporter.setExporterInput(new SimpleExporterInput(jp));
                xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput("CustomerFeedbackReport.xls"));
                SimpleXlsReportConfiguration xlsConfiguration = new SimpleXlsReportConfiguration();
                xlsConfiguration.setOnePagePerSheet(true);
                xlsConfiguration.setDetectCellType(true);
                xlsConfiguration.setCollapseRowSpan(false);
                xlsConfiguration.setRemoveEmptySpaceBetweenRows(true);
                xlsConfiguration.setWhitePageBackground(true);
                xlsExporter.setConfiguration(xlsConfiguration);
                xlsExporter.exportReport();
                File myFile = new File("CustomerFeedbackReport.xls");
                Desktop.getDesktop().open(myFile);
            } catch (ColumnBuilderException | ClassNotFoundException | JRException | IOException e) {
                e.printStackTrace();
                throw new RocException(e.getMessage(), e);
            }
        }
    }

    /**
     * Method to notify resolving teams when new order is generated.
     *
     * @param feedbackInfo - The feedback order that was generated
     * @param referenceNumber - The reference id of the order
     * @throws org.unisiegen.roc.exception.RocException
     */
    public void sendEmailNotification(Feedback feedbackInfo, long referenceNumber) throws RocException {
        try {
            if (feedbackInfo != null && referenceNumber > 0) {
                // Generate detailed report to send as file attachment            
                List<Feedback> feedbackList = new ArrayList<>();
                feedbackList.add(feedbackInfo);
                isEmail = true;
                generatePDFReport(feedbackList, "Detailed");
                // Get receiver address of respective team
                String receiverAddress = "";
                List<ResolvingTeam> teamList = getTeamCollectionByIssue(feedbackInfo.getIssue());
                if (teamList != null && !teamList.isEmpty() && feedbackInfo.getResolvingTeam() != null) {
                    List<ResolvingTeam> teams = teamList.stream().filter(item -> item.getTeamId() == feedbackInfo.getResolvingTeam().getTeamId()).collect(Collectors.toList());
                    ResolvingTeam team = (teams != null && teams.size() == 1) ? teams.get(0) : null;
                    receiverAddress = (team != null) ? team.getEmailAddress() : "mailtoprakashpatil@gmail.com";
                }
                // Subject for resolving team and customer
                String mailSubject = "Order Reference Number - " + Long.toString(referenceNumber) + " " + feedbackInfo.getSubject();
                // Body of message with user comments for resolving team
                String mailBody = "Hello Team, \n\nPlease look into the referred Work Order - " + Long.toString(referenceNumber)
                        + " .\n\nComments from Client - " + feedbackInfo.getComments()
                        + " \n\nRegards,\nROC Help Desk.";
                sendMail(receiverAddress, mailSubject, mailBody);
                receiverAddress = feedbackInfo.getCustomer() != null ? feedbackInfo.getCustomer().getEmailId() : "";
                // Body of message with user comments for resolving team
                mailBody = "Hello " + feedbackInfo.getCustomer().getContactPerson()
                        + ", \n\nPlease find the reference number of the Work Order you have raised - "
                        + Long.toString(referenceNumber)
                        + " .\n\nThe respective team will be shortly addressing your issue."
                        + " \n\nRegards,\nROC Help Desk.";
                if (!receiverAddress.isEmpty()) {
                    sendMail(receiverAddress, mailSubject, mailBody);
                }
            }
        } catch (RocException ex) {
            throw new RocException(ex.getMessage(), ex);
        }
    }

    /**
     * Method to verify any given input as per the verification clause.
     *
     * @param input - The input which is to be verified
     * @param verificationClause - The clause indicates the validation that must
     * be performed
     * @return Output of validating the input
     */
    public boolean verifyInput(String input, String verificationClause) {
        boolean isValid = false;
        if (input != null && !input.isEmpty() && verificationClause != null && !verificationClause.isEmpty()) {
            String VERIFICATION_PATTERN = "";
            switch (verificationClause) {
                case "Email":
                    VERIFICATION_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
                    break;

                case "Search":
                    VERIFICATION_PATTERN = "^[0-9]{1,10}$";
                    break;

                case "Phone":
                    VERIFICATION_PATTERN = "^([+]?\\d{1,2}[-\\s]?|)\\d{3}[-\\s]?\\d{3}[-\\s]?\\d{5}$";
                    break;
            }
            Pattern regexPattern = Pattern.compile(VERIFICATION_PATTERN);
            Matcher validMatch = regexPattern.matcher(input);
            isValid = validMatch.matches();
        }

        return isValid;
    }
    // </editor-fold>

    // <editor-fold desc="Private Methods">
    /**
     * Performs adjustments to internal frame properties to set inside desktop
     * pane.
     *
     * @param frame - Internal frame whose properties are adjusted
     * @param pane - Desktop pane within which internal frame needs to be set
     * @param frameName - Name of the internal frame
     */
    private void setFrameToPane(JInternalFrame frame, JDesktopPane pane, String frameName) {
        if (frame != null && pane != null && frameName != null) {
            frame.setVisible(true);
            frame.setResizable(true);
            frame.putClientProperty("dragMode", "fixed");
            setInternalFrameSize(pane, frame, frameName);
            //pane.setLayout(new BorderLayout());
            pane.add(frame);
            pane.addComponentListener(new ComponentListener() {

                @Override
                public void componentResized(ComponentEvent ce) {
                    setInternalFrameSize(pane, pane.getAllFrames()[0], frameName);
                }

                @Override
                public void componentMoved(ComponentEvent ce) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void componentShown(ComponentEvent ce) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void componentHidden(ComponentEvent ce) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            MasterScreen.deactivateMenuItem(!(frameName.equals("LoginScreen")));
        }
    }

    /**
     * Performs adjustments to internal frame size to set inside desktop pane.
     *
     * @param pane - Desktop pane within which internal frame needs to be set
     * @param frame - Internal frame whose size is adjusted
     * @param frameName - Name of the internal frame
     */
    private void setInternalFrameSize(JDesktopPane pane, JInternalFrame frame, String frameName) {
        Dimension size = null;
        for (int i = 0; i < pane.getComponentCount(); i++) {
            if (pane.getComponent(i).getClass() == JPanel.class) {
                size = new Dimension(pane.getComponent(i).getWidth(), pane.getComponent(i).getHeight());
            }
        }

        if (!(frameName.equals("LoginScreen")) && size != null) {
            frame.setBounds(0, 52, pane.getWidth(), pane.getHeight() - size.height);
        } else {
            frame.setBounds(0, 0, pane.getWidth(), pane.getHeight());
        }
    }

    /**
     * Performs service to send mail with file attachment.
     *
     * @param receiverAddress - Address of email to where the mail will be sent
     * @param mailSubject - Mail subject text
     * @param mailBody - Mail body of message text
     * @throws RocException
     */
    private void sendMail(String receiverAddress, String mailSubject, String mailBody) throws RocException {
        try {
            Email email = new Email();
            email.setReceiverAddress(receiverAddress);
            email.setMessageSubject(mailSubject);
            email.setMessageBody(mailBody);
            email.setAttachmentFileName("CustomerFeedbackReport.pdf");
            SendEmail sendEmail = new SendEmail();
            sendEmail.sendMailWithAttachment(email);
            isEmail = false;
        } catch (Exception ex) {
            throw new RocException(ex.getMessage(), ex);
        }
    }
    // </editor-fold>
    private RocDao rocDao;
    private long searchId;
    private boolean searchValid;
    private boolean isEmail = false;
}
