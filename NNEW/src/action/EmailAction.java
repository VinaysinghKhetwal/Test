package action;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
public class EmailAction  extends Authenticator{

	
	private String from;
	private String password;
    private String to;
    private String subject;
    private String body;


    static Properties properties = new Properties();
    static {
       properties.put("mail.smtp.host", "smtp.gmail.com");
       properties.put("mail.smtp.socketFactory.port", "465");
       properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
       properties.put("mail.smtp.auth", "true");
       properties.put("mail.smtp.port", "465");
    }

    public String mailM() {
        String ret = "SUCCESS";
        System.out.println("hiii");
        try {
           Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
                 protected PasswordAuthentication getPasswordAuthentication() {
                    return new  PasswordAuthentication("templatesbazar@gmail.com", "templates@bazar");
                 }
              }
           );

           MimeMessage message = new MimeMessage(session);
           message.setFrom(new InternetAddress("templatesbazar@gmail.com"));
           message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("vinaysinghkhetwal.16@gmail.com"));
           message.setSubject("test");
           message.setText("hii");
           Transport.send(message);
        } catch(Exception e) {
           ret = "ERROR";
           e.printStackTrace();
        }
        return ret;
     }

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public static Properties getProperties() {
		return properties;
	}

	public static void setProperties(Properties properties) {
		EmailAction.properties = properties;
	}
}*/

public class EmailAction  
{  
 public static void main(String [] args){  
      String to = "vinaysinghkhetwal.16@gmail.com";//change accordingly  
      String from = "templatesbazar@gmail.com"; //change accordingly  
      String host = "smtp.gmail.com";//or IP address  
  
     //Get the session object  
      Properties properties = System.getProperties();  
      properties.setProperty("mail.smtp.host", host);  
      Session session = Session.getDefaultInstance(properties);  
  
     //compose the message  
      try{  
         MimeMessage message = new MimeMessage(session);  
         message.setFrom(new InternetAddress(from));  
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
         message.setSubject("Ping");  
         message.setText("Hello, this is example of sending email  ");  
  
         // Send message  
         Transport.send(message);  
         System.out.println("message sent successfully....");  
  
      }catch (MessagingException mex) {mex.printStackTrace();}  
   }  
}  