/* 
 * Institute of Knowledge Based Systems and Knowledge Management,
 * Department of Electrical Engineering and Computer Science,
 * Faculty of Science and Technology, University of Siegen, Germany
 * Winter Semester 2015/16  © 2015-2016 | All right reserved for University of Siegen
 */
package org.unisiegen.roc.report;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.unisiegen.roc.domain.Feedback;
import org.unisiegen.roc.domain.FeedbackReport;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.AutoText;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilder;
import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import ar.com.fdvs.dj.domain.builders.DynamicReportBuilder;
import ar.com.fdvs.dj.domain.builders.StyleBuilder;
import ar.com.fdvs.dj.domain.constants.Border;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.constants.Transparency;
import ar.com.fdvs.dj.domain.constants.VerticalAlign;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author RebellionPC
 *
 */
public class FeedbackReportXLS {

    private List<Feedback> feedbackResult = new ArrayList<Feedback>();

    /**
     * 
     * @param feedbackList 
     */
    public FeedbackReportXLS(List<Feedback> feedbackList) {
        feedbackResult = feedbackList;
    }

    public JasperPrint getReport(String reportType) throws ColumnBuilderException, JRException, ClassNotFoundException {
        List<JasperPrint> jasperPrintList = getJasperList(reportType);
        JasperPrint printAll = new JasperPrint();
        for (JasperPrint jasperPrint : jasperPrintList) {
            for (int i = 0; i < jasperPrint.getPages().size(); i++) {
                printAll.addPage((JRPrintPage) jasperPrint.getPages().get(i));
            }
        }

        printAll.setPageHeight(842);
        printAll.setPageWidth(595);
        return printAll;
    }

    private Style createHeaderStyle() {
        StyleBuilder sb = new StyleBuilder(true);
        sb.setFont(Font.VERDANA_MEDIUM_BOLD);
        sb.setBorder(Border.THIN());
        sb.setBorderBottom(Border.PEN_2_POINT());
        sb.setBorderColor(Color.BLACK);
        Color color = new Color(28, 114, 12);
        sb.setBackgroundColor(color);
        sb.setTextColor(Color.BLACK);
        sb.setHorizontalAlign(HorizontalAlign.CENTER);
        sb.setVerticalAlign(VerticalAlign.MIDDLE);
        sb.setTransparency(Transparency.OPAQUE);
        return sb.build();
    }

    private Style createDetailTextStyle() {
        StyleBuilder sb = new StyleBuilder(true);
        sb.setFont(Font.VERDANA_MEDIUM);
        sb.setBorder(Border.DOTTED());
        sb.setBorderColor(Color.BLACK);
        Color color = new Color(28, 114, 12);
        sb.setTextColor(color);
        sb.setHorizontalAlign(HorizontalAlign.LEFT);
        sb.setVerticalAlign(VerticalAlign.MIDDLE);
        sb.setPaddingLeft(5);
        return sb.build();
    }

    private AbstractColumn createColumn(String property, Class type,
            String title, int width, Style headerStyle, Style detailStyle)
            throws ColumnBuilderException {
        AbstractColumn columnState = ColumnBuilder.getNew()
                .setColumnProperty(property, type.getName()).setTitle(
                        title).setWidth(Integer.valueOf(width))
                .setStyle(detailStyle).setHeaderStyle(headerStyle).build();
        return columnState;
    }

    private DynamicReport setReportParams(String reportType) {
        Style headerStyle = createHeaderStyle();
        Style detailTextStyle = createDetailTextStyle();
        StyleBuilder titleStyle = new StyleBuilder(true);
        titleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
        titleStyle.setFont(new Font(20, Font._FONT_GEORGIA, true));

        StyleBuilder subTitleStyle = new StyleBuilder(true);
        subTitleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
        subTitleStyle.setFont(new Font(Font.MEDIUM, Font._FONT_GEORGIA, true));

        DynamicReportBuilder report = new DynamicReportBuilder();
        
        if (reportType.equals("NonDetailed")) {
            AbstractColumn columnFeedbackId = createColumn("feedbackId", Long.class, "Feedback Id", 30, headerStyle, detailTextStyle);
            AbstractColumn columnFeedbackSubject = createColumn("subject", String.class, "Subject", 110, headerStyle, detailTextStyle);
            AbstractColumn columnFeedbackPriority = createColumn("priority", String.class, "Priority", 30, headerStyle, detailTextStyle);
            AbstractColumn columnFeedbackTeamAssigned = createColumn("teamAssigned", String.class, "Team Assigned", 40, headerStyle, detailTextStyle);
            AbstractColumn columnFeedbackStatus = createColumn("status", String.class, "Status", 40, headerStyle, detailTextStyle);
            AbstractColumn columnFeedbackDate = createColumn("feedbackDate", Date.class, "Date", 60, headerStyle, detailTextStyle);
            report.addColumn(columnFeedbackId).addColumn(columnFeedbackSubject).addColumn(columnFeedbackPriority).
                    addColumn(columnFeedbackTeamAssigned).addColumn(columnFeedbackStatus).addColumn(columnFeedbackDate);
        } else {
            AbstractColumn columnFeedbackId = createColumn("feedbackId", Long.class, "Feedback Reference Number", 100, headerStyle, detailTextStyle);
            AbstractColumn columnCustomerName = createColumn("customerName", String.class, "Customer Name", 50, headerStyle, detailTextStyle);
            AbstractColumn columnContactPerson = createColumn("contactPerson", String.class, "Contact Person", 50, headerStyle, detailTextStyle);
            AbstractColumn columnEmailId = createColumn("emailId", String.class, "Email Id", 50, headerStyle, detailTextStyle);
            AbstractColumn columnPhoneNumber = createColumn("phoneNumber", Long.class, "Phone Number", 50, headerStyle, detailTextStyle);
            AbstractColumn columnProductName = createColumn("productName", String.class, "Product Name", 60, headerStyle, detailTextStyle);
            AbstractColumn columnModelNumber = createColumn("modelNumber", String.class, "Model Number", 60, headerStyle, detailTextStyle);
            AbstractColumn columnFeedbackType = createColumn("feedbackType", String.class, "Type of Feedback", 60, headerStyle, detailTextStyle);
            AbstractColumn columnSubject = createColumn("subject", String.class, "Subject", 100, headerStyle, detailTextStyle);
            AbstractColumn columnIssue = createColumn("issue", String.class, "Issue", 60, headerStyle, detailTextStyle);
            AbstractColumn columnTeamAssigned = createColumn("teamAssigned", String.class, "Team Assigned", 60, headerStyle, detailTextStyle);
            AbstractColumn columnPriority = createColumn("priority", String.class, "Priority", 60, headerStyle, detailTextStyle);
            AbstractColumn columnComments = createColumn("comments", String.class, "Comments", 150, headerStyle, detailTextStyle);
            AbstractColumn columnFeedbackDate = createColumn("feedbackDate", Date.class, "Date", 60, headerStyle, detailTextStyle);
            report.addColumn(columnFeedbackId).addColumn(columnCustomerName).addColumn(columnContactPerson).
                    addColumn(columnEmailId).addColumn(columnPhoneNumber).addColumn(columnProductName).addColumn(columnModelNumber)
                    .addColumn(columnFeedbackType).addColumn(columnSubject).addColumn(columnIssue).addColumn(columnTeamAssigned)
                    .addColumn(columnPriority).addColumn(columnComments).addColumn(columnFeedbackDate);
        }
        report.setTitle("Customer Feedback  Report");
        report.setSubtitle("This report was generated at " + new Date());
        report.setWhenNoData("No data for this report", null, true, true);
        report.setTitleStyle(titleStyle.build());
        report.setSubtitleStyle(subTitleStyle.build());
        report.setUseFullPageWidth(true);
        report.addAutoText(AutoText.AUTOTEXT_PAGE_X_OF_Y, AutoText.POSITION_FOOTER, AutoText.ALIGNMENT_LEFT);
        //  report.addImageBanner("u3.png", new Integer(800), new Integer(100), ImageBanner.ALIGN_LEFT);
        DynamicReport dynaReport = report.build();
        return dynaReport;
    }

    public List<JasperPrint> getJasperList(String reportType) throws JRException, ColumnBuilderException, ClassNotFoundException {
        JasperPrint jp = null;
        List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
        DynamicReport dynaReport = setReportParams(reportType);
        List<FeedbackReport> feedbackReports = new ArrayList<FeedbackReport>();
        FeedbackReport feedbackReport = null;
        for (Feedback feedback : feedbackResult) {
            feedbackReport = new FeedbackReport();
            feedbackReport.setCustomerName(feedback.getCustomer().getCustomerName());
            feedbackReport.setComments(feedback.getComments());
            feedbackReport.setContactPerson(feedback.getCustomer().getContactPerson());
            feedbackReport.setEmailId(feedback.getCustomer().getEmailId());
            feedbackReport.setFeedbackDate(feedback.getFeedbackDate());
            feedbackReport.setFeedbackId(feedback.getFeedbackId());
            if (feedback.getFeedbackType() == 0) {
                feedbackReport.setFeedbackType("Complain");
            } else {
                feedbackReport.setFeedbackType("Feedback");
            }

            feedbackReport.setIssue(feedback.getIssue().getIssueName());
            feedbackReport.setModelNumber(feedback.getModel().getModelNumber());
            feedbackReport.setPhoneNumber(feedback.getCustomer().getPhoneNumber());
            feedbackReport.setPriority(feedback.getPriority().getPriorityName());
            feedbackReport.setProductName(feedback.getModel().getProduct().getProductName());
            feedbackReport.setSubject(feedback.getSubject());
            feedbackReport.setTeamAssigned(feedback.getResolvingTeam().getTeamDescription());
            feedbackReport.setStatus(feedback.getStatus().getStatusDescription());
            feedbackReports.add(feedbackReport);
        }
        jp = DynamicJasperHelper.generateJasperPrint(dynaReport, new ClassicLayoutManager(), new JRBeanCollectionDataSource(feedbackReports));
        jasperPrintList.add(jp);

        return jasperPrintList;
    }

}
