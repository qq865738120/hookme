package top.geekarea.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 邮件工具类
 * Created by code_xia on 2017/4/20.
 */
public class MailUtil {

    /**
     * 发送邮件的方法
     * @param to 收件人
     * @param code 激活码
     */
    public static void sendMail(String to, String code) throws Exception {

        String body = "<h1>激活邮件</h1>" +
                "<a href='127.0.0.1:13145'>点击激活</a>";
        String userName = "qqq865738120@126.com";
        String password = "3.1415926535";

        Properties properties = new Properties();
        properties.setProperty("mail.debug", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.host", "smtp.126.com");
        properties.setProperty("mail.transport.protocol", "smtp");

        Session session = Session.getInstance(properties);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(userName));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("sjlfj");
        message.setContent(body, "text/html;charset=UTF-8");

        Transport transport = session.getTransport();
        transport.connect(userName, password);
        transport.sendMessage(message, new Address[] {new InternetAddress(to)});
        transport.close();
    }
}
