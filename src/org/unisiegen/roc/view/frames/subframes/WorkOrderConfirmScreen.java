/* 
 * Institute of Knowledge Based Systems and Knowledge Management,
 * Department of Electrical Engineering and Computer Science,
 * Faculty of Science and Technology, University of Siegen, Germany
 * Winter Semester 2015/16  © 2015-2016 | All right reserved for University of Siegen
 */
package org.unisiegen.roc.view.frames.subframes;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import org.unisiegen.roc.controller.MainController;
import org.unisiegen.roc.domain.Customer;
import org.unisiegen.roc.domain.Feedback;
import org.unisiegen.roc.domain.Issue;
import org.unisiegen.roc.domain.Model;
import org.unisiegen.roc.domain.Priority;
import org.unisiegen.roc.domain.Product;
import org.unisiegen.roc.domain.ResolvingTeam;
import org.unisiegen.roc.domain.Status;
import org.unisiegen.roc.domain.User;
import org.unisiegen.roc.exception.RocException;

/**
 * Provides user interface for work order confirmation in application.
 *
 * @author Pratik
 */
public class WorkOrderConfirmScreen extends javax.swing.JInternalFrame {

    // <editor-fold desc="Constructors">
    /**
     * Creates new form WorkOrderConfirmScreen
     */
    public WorkOrderConfirmScreen() {
        super("Work Order Summary");
        control = new MainController();
        frameDecorationRemoval();
        initComponents();
        isView = false;
        statusLabel.setVisible(false);
        statusText.setVisible(false);
    }

    // </editor-fold>
    // <editor-fold desc="NetBeans Auto Generated Code">        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        workOrderPane = new javax.swing.JScrollPane();
        workOrderPanel = new javax.swing.JPanel();
        companyInfoPanel = new javax.swing.JPanel();
        companyNameLabel = new javax.swing.JLabel();
        contactLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        companyNameText = new javax.swing.JLabel();
        contactPersonText = new javax.swing.JLabel();
        emailText = new javax.swing.JLabel();
        phoneText = new javax.swing.JLabel();
        productInfoPanel = new javax.swing.JPanel();
        productNameLabel = new javax.swing.JLabel();
        modelNumberLabel = new javax.swing.JLabel();
        productNameText = new javax.swing.JLabel();
        modelNumberText = new javax.swing.JLabel();
        feedbackPanel = new javax.swing.JPanel();
        feedbackTypeLabel = new javax.swing.JLabel();
        subjectLabel = new javax.swing.JLabel();
        issueLabel = new javax.swing.JLabel();
        teamLabel = new javax.swing.JLabel();
        priorityLabel = new javax.swing.JLabel();
        commentsLabel = new javax.swing.JLabel();
        subjectText = new javax.swing.JLabel();
        issueText = new javax.swing.JLabel();
        teamText = new javax.swing.JLabel();
        priorityText = new javax.swing.JLabel();
        commentsText = new javax.swing.JLabel();
        feedbackTypeText = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        statusText = new javax.swing.JLabel();
        flowPanel = new javax.swing.JPanel();
        editButton = new javax.swing.JButton();
        confirmButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 51, 51));

        workOrderPane.setBackground(new java.awt.Color(255, 255, 255));

        workOrderPanel.setBackground(new java.awt.Color(0, 51, 51));
        workOrderPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Work Order", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        workOrderPanel.setForeground(new java.awt.Color(255, 255, 255));

        companyInfoPanel.setBackground(new java.awt.Color(0, 51, 51));
        companyInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Company Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        companyNameLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        companyNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        companyNameLabel.setText("Company Name:");

        contactLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        contactLabel.setForeground(new java.awt.Color(255, 255, 255));
        contactLabel.setText("Contact Person:");

        emailLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("Email:");

        phoneLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        phoneLabel.setForeground(new java.awt.Color(255, 255, 255));
        phoneLabel.setText("Phone Number:");

        companyNameText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        companyNameText.setForeground(new java.awt.Color(255, 255, 255));
        companyNameText.setText("name");

        contactPersonText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        contactPersonText.setForeground(new java.awt.Color(255, 255, 255));
        contactPersonText.setText("contact");

        emailText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        emailText.setForeground(new java.awt.Color(255, 255, 255));
        emailText.setText("mail");

        phoneText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        phoneText.setForeground(new java.awt.Color(255, 255, 255));
        phoneText.setText("number");

        javax.swing.GroupLayout companyInfoPanelLayout = new javax.swing.GroupLayout(companyInfoPanel);
        companyInfoPanel.setLayout(companyInfoPanelLayout);
        companyInfoPanelLayout.setHorizontalGroup(
            companyInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(companyInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(companyInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(companyInfoPanelLayout.createSequentialGroup()
                        .addComponent(companyNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(companyNameText))
                    .addGroup(companyInfoPanelLayout.createSequentialGroup()
                        .addComponent(contactLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(contactPersonText))
                    .addGroup(companyInfoPanelLayout.createSequentialGroup()
                        .addGroup(companyInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(companyInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneText)
                            .addComponent(emailText))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        companyInfoPanelLayout.setVerticalGroup(
            companyInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(companyInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyNameText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(companyInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactLabel)
                    .addComponent(contactPersonText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(companyInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(companyInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(phoneText))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        productInfoPanel.setBackground(new java.awt.Color(0, 51, 51));
        productInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Product Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        productInfoPanel.setPreferredSize(new java.awt.Dimension(300, 90));

        productNameLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        productNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        productNameLabel.setText("Name:");

        modelNumberLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        modelNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        modelNumberLabel.setText("Model Number:");

        productNameText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        productNameText.setForeground(new java.awt.Color(255, 255, 255));
        productNameText.setText("product name");

        modelNumberText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        modelNumberText.setForeground(new java.awt.Color(255, 255, 255));
        modelNumberText.setText("model");

        javax.swing.GroupLayout productInfoPanelLayout = new javax.swing.GroupLayout(productInfoPanel);
        productInfoPanel.setLayout(productInfoPanelLayout);
        productInfoPanelLayout.setHorizontalGroup(
            productInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(modelNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(productInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productNameText)
                    .addComponent(modelNumberText))
                .addGap(60, 60, 60))
        );
        productInfoPanelLayout.setVerticalGroup(
            productInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productNameLabel)
                    .addComponent(productNameText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelNumberLabel)
                    .addComponent(modelNumberText))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        feedbackPanel.setBackground(new java.awt.Color(0, 51, 51));
        feedbackPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Feedback", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        feedbackTypeLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        feedbackTypeLabel.setForeground(new java.awt.Color(255, 255, 255));
        feedbackTypeLabel.setText("Type of Feedback:");

        subjectLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        subjectLabel.setForeground(new java.awt.Color(255, 255, 255));
        subjectLabel.setText("Subject:");

        issueLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        issueLabel.setForeground(new java.awt.Color(255, 255, 255));
        issueLabel.setText("Issue:");

        teamLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        teamLabel.setForeground(new java.awt.Color(255, 255, 255));
        teamLabel.setText("Team Assigned:");

        priorityLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        priorityLabel.setForeground(new java.awt.Color(255, 255, 255));
        priorityLabel.setText("Priority:");

        commentsLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        commentsLabel.setForeground(new java.awt.Color(255, 255, 255));
        commentsLabel.setText("Comments:");

        subjectText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        subjectText.setForeground(new java.awt.Color(255, 255, 255));
        subjectText.setText("subject");

        issueText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        issueText.setForeground(new java.awt.Color(255, 255, 255));
        issueText.setText("issue");

        teamText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        teamText.setForeground(new java.awt.Color(255, 255, 255));
        teamText.setText("team");

        priorityText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        priorityText.setForeground(new java.awt.Color(255, 255, 255));
        priorityText.setText("rank");

        commentsText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        commentsText.setForeground(new java.awt.Color(255, 255, 255));
        commentsText.setText("comment");

        feedbackTypeText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        feedbackTypeText.setForeground(new java.awt.Color(255, 255, 255));
        feedbackTypeText.setText("feedback");

        statusLabel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(255, 255, 255));
        statusLabel.setText("Status:");

        statusText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        statusText.setForeground(new java.awt.Color(255, 255, 255));
        statusText.setText("state");

        javax.swing.GroupLayout feedbackPanelLayout = new javax.swing.GroupLayout(feedbackPanel);
        feedbackPanel.setLayout(feedbackPanelLayout);
        feedbackPanelLayout.setHorizontalGroup(
            feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feedbackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(commentsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(priorityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(teamLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(issueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(subjectLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(feedbackTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                    .addComponent(statusLabel))
                .addGap(18, 18, 18)
                .addGroup(feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusText)
                    .addComponent(issueText)
                    .addComponent(teamText)
                    .addComponent(priorityText)
                    .addComponent(commentsText)
                    .addComponent(feedbackTypeText)
                    .addComponent(subjectText))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        feedbackPanelLayout.setVerticalGroup(
            feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feedbackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(feedbackTypeLabel)
                    .addComponent(feedbackTypeText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectLabel)
                    .addComponent(subjectText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issueLabel)
                    .addComponent(issueText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teamLabel)
                    .addComponent(teamText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priorityLabel)
                    .addComponent(priorityText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commentsLabel)
                    .addComponent(commentsText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel)
                    .addComponent(statusText)))
        );

        javax.swing.GroupLayout workOrderPanelLayout = new javax.swing.GroupLayout(workOrderPanel);
        workOrderPanel.setLayout(workOrderPanelLayout);
        workOrderPanelLayout.setHorizontalGroup(
            workOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workOrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(workOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(productInfoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(feedbackPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(companyInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        workOrderPanelLayout.setVerticalGroup(
            workOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workOrderPanelLayout.createSequentialGroup()
                .addComponent(companyInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(feedbackPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        workOrderPane.setViewportView(workOrderPanel);

        flowPanel.setBackground(new java.awt.Color(0, 51, 51));

        editButton.setBackground(new java.awt.Color(0, 102, 0));
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("EDIT");
        editButton.setToolTipText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        confirmButton.setBackground(new java.awt.Color(0, 102, 0));
        confirmButton.setForeground(new java.awt.Color(255, 255, 255));
        confirmButton.setText("CONFIRM");
        confirmButton.setToolTipText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout flowPanelLayout = new javax.swing.GroupLayout(flowPanel);
        flowPanel.setLayout(flowPanelLayout);
        flowPanelLayout.setHorizontalGroup(
            flowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(flowPanelLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        flowPanelLayout.setVerticalGroup(
            flowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, flowPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(flowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(confirmButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(workOrderPane)
                    .addComponent(flowPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(workOrderPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(flowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // </editor-fold>
    // <editor-fold desc="Events">
    /**
     * Edit button action event.
     *
     * @param evt Action event
     */
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        Feedback feedbackInfo = collectFeedbackDetails();
        JDesktopPane desktopPane = this.getDesktopPane();
        if (desktopPane != null) {
            if (!this.isView) {
                control.moveToOrderEdit(desktopPane, feedbackInfo);                
            } else {
                control.moveToOrderUpdate(desktopPane, feedbackInfo);
            }
            this.dispose();
        }
    }//GEN-LAST:event_editButtonActionPerformed

    /**
     * Confirm button action event.
     *
     * @param evt Action event
     */
    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        JDesktopPane desktopPane = this.getDesktopPane();
        if (!this.isView) {
            Feedback feedbackInfo = collectFeedbackDetails();
            long referenceNumber;
            try {
                referenceNumber = control.submitFeedback(feedbackInfo);
                if (referenceNumber > 0) {
                    control.sendEmailNotification(feedbackInfo, referenceNumber);
                    JOptionPane.showMessageDialog(this, "Work order submitted successfully!! \n Reference ID: " + String.valueOf(referenceNumber));
                } else {
                    JOptionPane.showMessageDialog(this, "Work order submission failed! \n Try again later..", "Error Message", JOptionPane.ERROR_MESSAGE);
                }
            } catch (RocException ex) {
                Logger.getLogger(WorkOrderConfirmScreen.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "RoC Error Message", JOptionPane.ERROR_MESSAGE);
            }
            
            if (desktopPane != null) {
                control.addFrameToPane(desktopPane, "MainMenuScreen");
                this.dispose();
            }
        } else {
            if (desktopPane != null) {
                control.addFrameToPane(desktopPane, "UpdateWorkOrderScreen");
                this.dispose();
            }
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

    // </editor-fold>
    // <editor-fold desc="Private Methods">
    /**
     * Method to remove unnecessary decoration from internal frame.
     */
    private void frameDecorationRemoval() {
        control.removeInternalFrameDecoration(this);
    }

    /**
     * Method to collect all the feedback details for order submission.
     *
     * @return Feedback details
     * @throws NumberFormatException
     */
    private Feedback collectFeedbackDetails() throws NumberFormatException {
        Feedback feedbackInfo = null;
        try {
            feedbackInfo = new Feedback();
            Customer customerInfo = new Customer();
            customerInfo.setCustomerName(companyNameText.getText());
            if (this.isView) {
                customerInfo.setCustomerId(Integer.parseInt(companyNameText.getName()));
                feedbackInfo.setFeedbackId(this.viewFeedbackId);
            }
            customerInfo.setContactPerson(contactPersonText.getText());
            customerInfo.setEmailId(emailText.getText());
            customerInfo.setPhoneNumber(Long.parseLong(phoneText.getText()));
            feedbackInfo.setCustomer(customerInfo);
            Product productInfo = new Product();
            productInfo.setProductName(productNameText.getText());
            productInfo.setProductId(Integer.parseInt(productNameText.getName()));
            Model modelInfo = new Model();
            modelInfo.setModelId(Integer.parseInt(modelNumberText.getName()));
            String[] model = modelNumberText.getText().split("-");
            if (model != null && model.length == 2 && !(model[0].trim().isEmpty()) && !(model[1].trim().isEmpty())) {
                modelInfo.setModelDescription(model[0].trim());
                modelInfo.setModelNumber(model[1].trim());
            }
            modelInfo.setProduct(productInfo);
            feedbackInfo.setModel(modelInfo);
            feedbackInfo.setSubject(subjectText.getText());
            feedbackInfo.setComments(commentsText.getText());
            feedbackInfo.setFeedbackDate(new Date());
            
            Status statusInfo = new Status();
            if (!this.isView) {
                // Default setting for status information
                statusInfo.setStatusId(1);
                statusInfo.setStatusDescription("Pending");
            } else {
                statusInfo.setStatusId(Integer.parseInt(statusText.getName()));
                statusInfo.setStatusDescription(statusText.getText());
            }
            feedbackInfo.setStatus(statusInfo);
            if (feedbackTypeText.getText().equals("Customer Complain")) {
                feedbackInfo.setFeedbackType(0);
                Issue issueInfo = new Issue();
                issueInfo.setIssueId(Integer.parseInt(issueText.getName()));
                issueInfo.setIssueName(issueText.getText());
                feedbackInfo.setIssue(issueInfo);
                
                Priority priorityInfo = new Priority();
                priorityInfo.setPriorityId(Integer.parseInt(priorityText.getName()));
                priorityInfo.setPriorityName(priorityText.getText());
                feedbackInfo.setPriority(priorityInfo);
                
                ResolvingTeam teamInfo = new ResolvingTeam();
                teamInfo.setTeamId(Integer.parseInt(teamText.getName()));
                teamInfo.setTeamDescription(teamText.getText());
                feedbackInfo.setResolvingTeam(teamInfo);
            } else {
                feedbackInfo.setFeedbackType(1);
                Issue issueInfo = new Issue();
                issueInfo.setIssueId(6);
                issueInfo.setIssueName("Statistical Data");
                feedbackInfo.setIssue(issueInfo);
                
                Priority priorityInfo = new Priority();
                priorityInfo.setPriorityId(1);
                priorityInfo.setPriorityName("Low");
                feedbackInfo.setPriority(priorityInfo);
                
                ResolvingTeam teamInfo = new ResolvingTeam();
                teamInfo.setTeamId(6);
                teamInfo.setTeamDescription("Statistical Team");
                feedbackInfo.setResolvingTeam(teamInfo);
            }
            
            User endUser = LoginScreen.getUserDetails();
            if (endUser != null) {
                feedbackInfo.setUser(endUser);
            }
        } catch (NumberFormatException ex) {
            Logger.getLogger(WorkOrderConfirmScreen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "RoC Error Message", JOptionPane.ERROR_MESSAGE);
        }
        
        return feedbackInfo;
    }

    // </editor-fold>
    // <editor-fold desc="Public Methods">
    /**
     * Method to fill the work order form with feedback details.
     *
     * @param order Feedback details to be filled
     */
    public void populateOrderDetails(Feedback order) {
        Customer customerInfo = order.getCustomer();
        if (customerInfo != null) {
            companyNameText.setText(customerInfo.getCustomerName());
            contactPersonText.setText(customerInfo.getContactPerson());
            emailText.setText(customerInfo.getEmailId());
            phoneText.setText(String.valueOf(customerInfo.getPhoneNumber()));
            if (this.isView) {
                companyNameText.setName(String.valueOf(customerInfo.getCustomerId()));
                this.viewFeedbackId = order.getFeedbackId();
            }
        }
        
        Model modelInfo = order.getModel();
        if (modelInfo != null) {
            modelNumberText.setText(modelInfo.getModelDescription() + " - " + modelInfo.getModelNumber());
            modelNumberText.setName(String.valueOf(modelInfo.getModelId()));
            if (modelInfo.getProduct() != null) {
                productNameText.setText(modelInfo.getProduct().getProductName());
                productNameText.setName(String.valueOf(modelInfo.getProduct().getProductId()));
            }
        }
        
        subjectText.setText(order.getSubject());
        commentsText.setText(order.getComments());
        
        if (Long.compare(order.getFeedbackType(), 0) == 0) {
            feedbackTypeText.setText("Customer Complain");
            if (order.getIssue() != null) {
                issueText.setText(order.getIssue().getIssueName());
                issueText.setName(String.valueOf(order.getIssue().getIssueId()));
            }
            
            if (order.getResolvingTeam() != null) {
                teamText.setText(order.getResolvingTeam().getTeamDescription());
                teamText.setName(String.valueOf(order.getResolvingTeam().getTeamId()));
            }
            
            if (order.getPriority() != null) {
                priorityText.setText(order.getPriority().getPriorityName());
                priorityText.setName(String.valueOf(order.getPriority().getPriorityId()));
            }
        } else {
            feedbackTypeText.setText("Customer Feedback");
            issueLabel.setVisible(false);
            issueText.setVisible(false);
            teamLabel.setVisible(false);
            teamText.setVisible(false);
            priorityLabel.setVisible(false);
            priorityText.setVisible(false);
            feedbackPanel.remove(issueLabel);
            feedbackPanel.remove(issueText);
            feedbackPanel.remove(teamLabel);
            feedbackPanel.remove(teamText);
            feedbackPanel.remove(priorityLabel);
            feedbackPanel.remove(priorityText);
        }
        
        if (this.isView && order.getStatus() != null) {            
            statusText.setText(order.getStatus().getStatusDescription());
            statusText.setName(String.valueOf(order.getStatus().getStatusId()));
            statusText.setVisible(true);
            statusLabel.setVisible(true);
        }
    }

    /**
     * Method to set view for displaying feedback details.
     *
     * @param isView View activation flag
     */
    public void setView(boolean isView) {
        this.isView = isView;
        confirmButton.setText("BACK");
        confirmButton.setToolTipText("Back");
    }
    // </editor-fold>

    private boolean isView;
    private long viewFeedbackId;
    private final MainController control;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel commentsLabel;
    private javax.swing.JLabel commentsText;
    private javax.swing.JPanel companyInfoPanel;
    private javax.swing.JLabel companyNameLabel;
    private javax.swing.JLabel companyNameText;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel contactLabel;
    private javax.swing.JLabel contactPersonText;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailText;
    private javax.swing.JPanel feedbackPanel;
    private javax.swing.JLabel feedbackTypeLabel;
    private javax.swing.JLabel feedbackTypeText;
    private javax.swing.JPanel flowPanel;
    private javax.swing.JLabel issueLabel;
    private javax.swing.JLabel issueText;
    private javax.swing.JLabel modelNumberLabel;
    private javax.swing.JLabel modelNumberText;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel phoneText;
    private javax.swing.JLabel priorityLabel;
    private javax.swing.JLabel priorityText;
    private javax.swing.JPanel productInfoPanel;
    private javax.swing.JLabel productNameLabel;
    private javax.swing.JLabel productNameText;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel statusText;
    private javax.swing.JLabel subjectLabel;
    private javax.swing.JLabel subjectText;
    private javax.swing.JLabel teamLabel;
    private javax.swing.JLabel teamText;
    private javax.swing.JScrollPane workOrderPane;
    private javax.swing.JPanel workOrderPanel;
    // End of variables declaration//GEN-END:variables
}