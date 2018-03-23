package com.hfut.util;

import com.hfut.exception.CustomException;
import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class ToolKit {
    /**
     * 根据字节数组获取File
     *
     * @param b          字节数组
     * @param outputFile 输出的路径(保存路径)
     * @return
     */
    public static File getFileFromBytes(byte[] b, String outputFile) throws CustomException {
        BufferedOutputStream stream = null;

        File file;
        try {
            file = new File(outputFile);
            FileOutputStream fstream = new FileOutputStream(file);
            stream = new BufferedOutputStream(fstream);
            stream.write(b);
        } catch (Exception e) {
            throw new CustomException("文件保存出错" + e);
        } finally {

            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e1) {
                    throw new CustomException("文件流关闭出错");
                }
            }
        }
        return file;
    }

    public static void deleteFile(String path) {
        File file = new File(path);
        file.delete();
    }

    public static String psw2pwd(String s) {
        String psw = Encryp.strDec(s, "amoxu", "amoxu", "amoxu");
        return Encryp.encryptionStr(psw + "amoxu", "MD5");
    }

    public static String web2Word(String s) {
        return Encryp.strDec(s, "amoxu", "amoxu", "amoxu");
    }

    public static String word2Psw(String s) {
        return Encryp.encryptionStr(s + "amoxu", "MD5");
    }

    /**
     * 发送邮件
     *
     * @throws Exception
     *//*
    public static void sendMsg(String toAddress, String subject, String content) throws Exception {
        //1.设置邮件的一些信息
        Properties props = new Properties();
        //发送邮件的服务器地址
        props.put("mail.smtp.host", "smtp.163.com");//smtp.qq.com stmp.sina.com
        props.put("mail.smtp.auth", "true");
        //2.创建Session对象
        Session session = Session.getInstance(props);
        //3.创建出MimeMessage，邮件的消息对象
        MimeMessage message = new MimeMessage(session);
        //4.设置发件人
        Address fromAddr = new InternetAddress("发件人邮箱");
        message.setFrom(fromAddr);

        //5.设置收件人
        Address toAddr = new InternetAddress(toAddress);
        message.setRecipient(RecipientType.TO, toAddr);

        //6.设置邮件的主题
        message.setSubject(subject);

        //7.设置邮件的正文
        message.setText(content);
        message.saveChanges();//保存更新

        //8.得到火箭
        Transport transport = session.getTransport("smtp");

        transport.connect("smtp.163.com", "发件人邮箱", "发件人密码"); //设置了火箭的发射地址

        transport.sendMessage(message, message.getAllRecipients());//发送具体内容及接收人

        transport.close();
    }
*/

}
