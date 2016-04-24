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
                return new PasswordAuthentication("sevice@shop.com","111");
            }
        });
        Message message=new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("service@shop.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("来自购物商城官方激活邮件");
            /*需要修改*/
            message.setContent("<h1>购物天堂传智商城官方激活邮件!点下面链接完成激活操作!</h1><h3><a href='http://192.168.36.103:8080/shop/user_active.action?code="+code+"'>http://192.168.36.103:8080/shop/user_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
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
