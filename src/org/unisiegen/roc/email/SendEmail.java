/* 
 * Institute of Knowledge Based Systems and Knowledge Management,
 * Department of Electrical Engineering and Computer Science,
 * Faculty of Science and Technology, University of Siegen, Germany
 * Winter Semester 2015/16  © 2015-2016 | All right reserved for University of Siegen
 */
package org.unisiegen.roc.email;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.unisiegen.roc.domain.Email;

/**
 * @author RebellionPC
 *
 */
public class SendEmail {

    /**
     *
     */
    public SendEmail() {

    }

    public void sendMailWithAttachment(Email email) {

        // Recipient's email ID needs to be mentioned.
        String receiver = email.getReceiverAddress();

        // Sender's email ID needs to be mentioned
        String sender = "rochelpdeskp5@gmail.com";
        String password = "rochelpdesk237";

        // Get system properties
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, password);
            }
        });
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(sender));

            // Set To: header field of the header.
            message.setRecipient(Message.RecipientType.TO,
                    new InternetAddress(receiver));

            // Set Subject: header field
            message.setSubject(email.getMessageSubject());

            // Create the message part 
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            messageBodyPart.setText(email.getMessageBody());

            // Create a multipart message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = email.getAttachmentFileName();
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message, message.getAllRecipients());
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            System.out.println("message not sent....");
        }
    }

}
