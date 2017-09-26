package com.s3.Sendmail;

    import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
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

import com.s3.utility.Constant;  
      
    public class SendReport{  
      public static void ReportSend(String Zipfilename){ 
    	 String returnedEmailids = Constant.MAIL_TO;
 		 String [] strings = returnedEmailids.split(",");
 		 List<String> recipients = Arrays.asList(strings);
 				      
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
    	
        String timeStamp = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
        message.setSubject("AMP automation Regression results "+ timeStamp);  
          
        //3) create MimeBodyPart object and set your message text     
        BodyPart messageBodyPart1 = new MimeBodyPart();  
        messageBodyPart1.setText("Please open the attached file for results of AMP Regression Test Execution");  
          
        //4) create new MimeBodyPart object and set DataHandler object to this object      
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
        MimeBodyPart messageBodyPart3 = new MimeBodyPart();  

        String filename1 = "Reports/S3Test_Results.xlsx";//change accordingly  
        DataSource source = new FileDataSource(filename1);  
        messageBodyPart2.setDataHandler(new DataHandler(source));  
        messageBodyPart2.setFileName(filename1);  
         
        String filename11 =Zipfilename+".zip" ;//change accordingly  
        DataSource source1 = new FileDataSource(filename11);  
        messageBodyPart3.setDataHandler(new DataHandler(source1));  
        messageBodyPart3.setFileName(filename11);  
         
        //5) create Multipart object and add MimeBodyPart objects to this object      
        Multipart multipart = new MimeMultipart();  
        multipart.addBodyPart(messageBodyPart1);  
        multipart.addBodyPart(messageBodyPart2);  
        multipart.addBodyPart(messageBodyPart3);  
        
        //6) set the multiplart object to the message object  
        message.setContent(multipart );  
         
        //7) send message  
        Transport.send(message);  
       
       System.out.println("message sent....");  
       }catch (MessagingException ex) {ex.printStackTrace();}  
     }  
    }  