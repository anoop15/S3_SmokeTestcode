package com.s3.utility;

    import java.text.SimpleDateFormat;
import java.util.*;  
    import javax.mail.*;  
    import javax.mail.internet.*;

import org.testng.annotations.Test;

import javax.activation.*;  
      
    public class SendSmokeReport{  
     //public static void main(String [] args){  
      @Test
      public void ReportSend(){ 
    	 String returnedEmailids=Constant.MAIL_TO;
    	 String [] strings = returnedEmailids.split(",");
 		 List<String> recipients = Arrays.asList(strings);
 		 //   String to1=Constant.MAIL_TO1;//change accordingly  
      final String user="dubtester21@gmail.com	";//change accordingly  
      final String password="abababababab";//change accordingly  
       
      //1) get the session object     
      //Properties properties = System.getProperties();  
     // properties.setProperty("mail.smtp.host", "smtp.gmail.com");  
    //  properties.put("mail.smtp.auth", "true");  
      Properties properties = new Properties();  

      properties.setProperty("mail.transport.protocol", "smtp");     
      properties.setProperty("mail.host", "smtp.gmail.com");  
      properties.put("mail.smtp.auth", "true");  
      properties.put("mail.smtp.port", "465");  
      properties.put("mail.debug", "true");  
      properties.put("mail.smtp.socketFactory.port", "465");  
      properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
      properties.put("mail.smtp.socketFactory.fallback", "false");  
      
     
      
      Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
    	    protected PasswordAuthentication getPasswordAuthentication() {
    	        return new PasswordAuthentication(user, password);
    	    }
    	});
         
      //2) compose message     
      try{  
        MimeMessage message = new MimeMessage(session);  
        message.setFrom(new InternetAddress(user));  
        for(String recpt : recipients){
       	 message.addRecipient(Message.RecipientType.TO,new InternetAddress(recpt));  
       }
        
        //message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
    //    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to1));  
    	String timeStamp = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
        message.setSubject("AMP automation smoke results "+ timeStamp);  
          
        //3) create MimeBodyPart object and set your message text     
        BodyPart messageBodyPart1 = new MimeBodyPart();  
        messageBodyPart1.setText("Please open the attached file for results of AMP somke Test Execution");  
          
        //4) create new MimeBodyPart object and set DataHandler object to this object      
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
      
        String filename = "Reports/S3AutomationTestStatus.xlsx";//change accordingly  
        DataSource source = new FileDataSource(filename);  
        messageBodyPart2.setDataHandler(new DataHandler(source));  
        messageBodyPart2.setFileName(filename);  
         
         
        //5) create Multipart object and add MimeBodyPart objects to this object      
        Multipart multipart = new MimeMultipart();  
        multipart.addBodyPart(messageBodyPart1);  
        multipart.addBodyPart(messageBodyPart2);  
      
        //6) set the multiplart object to the message object  
        message.setContent(multipart );  
         
        //7) send message  
        Transport.send(message);  
       
       System.out.println("message sent....");  
       }catch (MessagingException ex) {ex.printStackTrace();}  
     }  
    }  