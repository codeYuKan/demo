package com.yukan.demo.email;

import com.yukan.demo.email.model.EmailProperty;
import lombok.extern.slf4j.Slf4j;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * @author yukan
 * @date 2019/12/13
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class EmailDemo {

    private Session newSessionInstance(EmailProperty emailProperty) {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.host", emailProperty.getStmpHost());
        properties.setProperty("mail.smtp.auth", "true");

        return Session.getInstance(properties);
    }

    public void sendEmail(EmailProperty emailProperty) throws MessagingException {
        Session session = newSessionInstance(emailProperty);
        MimeMessage mimeMessage = new MimeMessage(session);
        MimeMultipart multipart = new MimeMultipart();

        mimeMessage.setFrom(new InternetAddress(emailProperty.getSendMailAccount()));
        mimeMessage.setSubject(emailProperty.getMailSubject());
        mimeMessage.addRecipients(MimeMessage.RecipientType.TO, emailProperty.getSendTo());

        //MimeBodyPart mimeBodyPart = new MimeBodyPart();
        //DataHandler dataHandler = new DataHandler(new FileDataSource(emailProperty.getFileUrl()));
        //mimeBodyPart.setDataHandler(dataHandler);
        //mimeBodyPart.setFileName(dataHandler.getName());
        //
        //multipart.addBodyPart(mimeBodyPart);
        //mimeMessage.setContent(multipart);

        mimeMessage.setContent("ceshi", "text/html;charset=UTF-8");

        Transport transport = session.getTransport();
        transport.connect(emailProperty.getSendMailAccount(), emailProperty.getPassword());
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
    }

    public static void main(String[] args) throws MessagingException {
        EmailProperty emailProperty = EmailProperty.builder()
                .stmpHost("smtp.163.com")
                //.fileUrl()
                .mailSubject("测试")
                .password("yk1995dut")
                .sendMailAccount("yk2013dlut@163.com")
                .sendTo("754299248@qq.com")
                .build();
        EmailDemo demo = new EmailDemo();
        demo.sendEmail(emailProperty);
    }

}
