package utils;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by lily on 2016/4/22.
 */
public class MailUitls {
    public static void sendMail(String to,String code){
        Properties properties=new Properties();
        properties.setProperty("mail.host", "localhost");
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("service@shop.com","111");
            }
        });
        /*创建邮件对象*/
        Message message=new MimeMessage(session);
        /*设置发件人*/
        try {
            message.setFrom(new InternetAddress("service@shop.com"));
            /*设置收件人*/
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            /*设置标题*/
            message.setSubject("来自购物商城官方激活邮件");
            /*设置邮件正文*/
            message.setContent("<h1>购物天堂传智商城官方激活邮件!点下面链接完成激活操作!</h1><h3><a href='http://localhost:8080/preuserAction_active.action?code="+code+"'>http://localhost:8080/preuserAction_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
            /*发送邮件*/
            Transport.send(message);
        }catch (AddressException e){
            e.printStackTrace();
        }catch (MessagingException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        sendMail("aaa@shop.com","1111111111");
    }
}
