/*
 * Institute of Knowledge Based Systems and Knowledge Management,
 * Department of Electrical Engineering and Computer Science,
 * Faculty of Science and Technology, University of Siegen, Germany
 * Winter Semester 2015/16  © 2015-2016 | All right reserved for University of Siegen
 */
package org.unisiegen.roc.report;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.unisiegen.roc.domain.Feedback;
import org.unisiegen.roc.domain.FeedbackReport;
import org.unisiegen.roc.domain.FeedbackReports;

public class FeedbackReportPDF {

    private List<Feedback> feedbackResult = new ArrayList<Feedback>();

    public FeedbackReportPDF(List<Feedback> feedbackList) {
        feedbackResult = feedbackList;
    }

    public void getFormattedXML() {
        FeedbackReports feedbackReports = new FeedbackReports();
        feedbackReports.setFeedbacks(new ArrayList<FeedbackReport>());
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
                feedbackReport.setFeedbackType("Complaint");
            } else {
                feedbackReport.setFeedbackType("Feedback");
            }
            System.out.println("issue name is::" + feedback.getIssue().getIssueName());
            feedbackReport.setIssue(feedback.getIssue().getIssueName());
            feedbackReport.setModelNumber(feedback.getModel().getModelNumber());
            feedbackReport.setPhoneNumber(feedback.getCustomer().getPhoneNumber());
            feedbackReport.setPriority(feedback.getPriority().getPriorityName());
            feedbackReport.setProductName(feedback.getModel().getProduct().getProductName());
            feedbackReport.setSubject(feedback.getSubject());
            feedbackReport.setTeamAssigned(feedback.getResolvingTeam().getTeamDescription());
            feedbackReport.setStatus(feedback.getStatus().getStatusDescription());
            feedbackReports.getFeedbacks().add(feedbackReport);
        }
        File file = new File("formattedFeedbackXML.xml");
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(FeedbackReports.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(feedbackReports, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void getReport(String reportType) throws FOPException, TransformerException, IOException {
        getFormattedXML();
        // the XSL FO file
        File xsltFile;
        if (reportType.equals("NonDetailed")) {
            xsltFile = new File("GeneralFeedbackReport.xsl");
        } else {
            xsltFile = new File("DetailedFeedbackReportXSL.xsl");
        }

        // the XML file which provides the input
        StreamSource xmlSource = new StreamSource(new File("formattedFeedbackXML.xml"));
        // create an instance of fop factory
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        // a user agent is needed for transformation
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        // Setup output
        OutputStream out = new java.io.FileOutputStream("CustomerFeedbackReport.pdf");
        System.out.println("FOP XML2PDF\n");
        System.out.println("Preparing...");

        try {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            // Resulting SAX events (the generated FO) must be piped through to FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start XSLT transformation and FOP processing
            // That's where the XML is first transformed to XSL-FO and then 
            // PDF is created
            transformer.transform(xmlSource, res);
        } finally {
            out.close();
        }

    }

}
