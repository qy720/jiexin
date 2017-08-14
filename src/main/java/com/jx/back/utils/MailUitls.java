package com.jx.back.utils;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 邮箱验证工具类
 * Created by Administrator on 2017/4/13.
 */
public class MailUitls {
    /**
     * 发送邮件工具类:通过qq邮件发送,因为具有ssl加密,采用的是smtp协议
     * @param mailServer 邮件服务器的主机名:如 "smtp.qq.com"
     * @param loginAccount 登录邮箱的账号:如 "1974544863@qq.com"
     * @param loginAuthCode 登录qq邮箱时候需要的授权码:可以进入qq邮箱,账号设置那里"生成授权码"
     * @param sender 发件人
     * @param recipients 收件人:支持群发
     * @param emailSubject 邮件的主题
     * @param emailContent 邮件的内容
     * @param emailContentType 邮件内容的类型,支持纯文本:"text/plain;charset=utf-8";,带有Html格式的内容:"text/html;charset=utf-8"
     * @return
     */
    public static int sendEmail(String mailServer,final String loginAccount,final String loginAuthCode,String sender,String[] recipients,
                                String emailSubject,String emailContent,String emailContentType){
        int res=0;

        try {
            //跟smtp服务器建立一个连接
            Properties p = new Properties();
            //设置邮件服务器主机名
            p.setProperty("mail.host",mailServer);
            //发送服务器需要身份验证,要采用指定用户名密码的方式去认证
            p.setProperty("mail.smtp.auth", "true");
            //发送邮件协议名称
            p.setProperty("mail.transport.protocol", "smtp");

            //开启SSL加密，否则会失败
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            p.put("mail.smtp.ssl.enable", "true");
            p.put("mail.smtp.ssl.socketFactory", sf);

            // 创建session
            Session session = Session.getDefaultInstance(p, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    //用户名可以用QQ账号也可以用邮箱的别名:第一个参数为邮箱账号,第二个为授权码
                    PasswordAuthentication pa = new PasswordAuthentication(loginAccount,loginAuthCode);
                    return pa;
                }
            });

            //设置打开调试状态
            session.setDebug(true);

            //可以发送几封邮件:可以在这里 for循环多次
            //声明一个Message对象(代表一封邮件),从session中创建
            MimeMessage msg = new MimeMessage(session);
            //邮件信息封装
            //1发件人
            msg.setFrom(new InternetAddress(sender));

            //2收件人:可以多个
            //一个的收件人
            //msg.setRecipient(RecipientType.TO, new InternetAddress("linsenzhong@126.com"));

            InternetAddress[] receptientsEmail=new InternetAddress[recipients.length];
            for(int i=0;i<recipients.length;i++){
                receptientsEmail[i]=new InternetAddress(recipients[i]);
            }

            //多个收件人
            msg.setRecipients(Message.RecipientType.TO,receptientsEmail);

            //3邮件内容:主题、内容
            msg.setSubject(emailSubject);
            //msg.setContent("Hello, 我是debug!!!", );//纯文本
            msg.setContent(emailContent,emailContentType);//发html格式的文本
            //发送动作
            Transport.send(msg);
            System.out.println("邮件发送成功");
            res=1;

        } catch (Exception e) {
            System.out.println("邮件发送失败: "+e.getMessage());

            res=0;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        String code = "3306";
        int res=sendEmail("smtp.qq.com", "351374556@qq.com",
                "fsxoecznomrzbiha", "351374556@qq.com",
                new String[]{ "749058268@qq.com"}, "来自购物天堂传智商城官方激活邮件",
                "<h1>购物天堂传智商城官方激活邮件!点下面链接完成激活操作!</h1><h3><a href='http://192.168.1.210:8080/shop/user_active.action?code="+code+"'>http://192.168.1.210:8080/shop/user_active.action?code="+code+"</a></h3>",
                "text/html;charset=utf-8");

        /*int res=sendEmail("smtp.qq.com", "这里输入你的qq邮箱", "这里输入前面说到的授权码", "发送人的qq邮箱", new String[]{
                "1974544863@qq.com","linsenzhong@126.com" //这里就是一系列的收件人的邮箱了
        }, "节日祝福", "祝你国庆节快乐,欢迎来我的blog: <a href='http://blog.csdn.net/u013871100'>我的blog</a>,祝您生活愉快!","text/html;charset=utf-8");
*/
        System.out.println("\n发送结果:"+res);
    }
}