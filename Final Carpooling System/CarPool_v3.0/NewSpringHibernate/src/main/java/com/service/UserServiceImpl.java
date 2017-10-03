package main.java.com.service;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.dao.UserDAOImpl;
import main.java.com.dao.UserInterface;
import main.java.com.model.Booking;
import main.java.com.model.Trip;
import main.java.com.model.User;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserInterface userInter = new UserDAOImpl();
	private static final String MAIL_SERVER = "smtp";
	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
    private static final int SMTP_HOST_PORT = 465;
    private static final String USER_NAME = "inirah95";  // GMail user name (just the part before "@gmail.com")
    private static final String PASSWORD = "harini19"; // GMail password

	
	//@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void registerUser(User user) {
		userInter.registerUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userInter.getAllUsers();
	}

	@Override
	public User login(String email, String passwd) {
		User user = userInter.login(email, passwd);
		if(user !=null)
			return user;
		return null;
	}

	@Override
	public User getUserDetail(String email) {
		User user = userInter.getUserDetail(email);
		if(user!=null)
			return user;
		return null;
	}
	
	static char[] OTP(int len)
    {
        
        System.out.print("Your OTP is : ");
       String num="123456789";

        Random rm = new Random();
 
        char[] otp = new char[len];
 
        for (int i = 0; i < len; i++)
        {
            otp[i] =num.charAt(rm.nextInt(num.length()));
        }
        return otp;
    }
	
	public String confirmEmail(String email){
		int length =4;
		char[] otp = OTP(length);
		System.out.println(otp);
		
		String[] to = { "" }; // list of recipient email addresses
        String[] cc={ "" };
        String[] bcc={ email };
        String subject = "Validate your EmailID";
		
        String message = "Your OTP is : "+String.valueOf(otp);
        
        try {
			if(sendFromGMail(to, cc, bcc, subject, message))
					return String.valueOf(otp);
//			System.out.println("Email Sent....!");
			/*Scanner sc = new Scanner(System.in);
			System.err.println("Enter the received OTP :");
			String varifyOTP = sc.next();
			if(String.valueOf(otp).equals(varifyOTP)){
				System.out.println("verified");
			}
			else
			{
				System.out.println("Wrong");
			}*/
			
		} catch (Exception e) {
			System.out.println("Could not send email....!");
			e.printStackTrace();
		}
        return null;
		
	}
	
	private static boolean sendFromGMail(String[] to, String[] cc, String[] bcc, String subject, String body) {

		    	
		    	System.out.println("\n 1st ===> Setup SMTP Mail Server Properties..!");
		    	
		    	// Get system properties
		        Properties properties = System.getProperties();
		        
		        // Setup mail server        
		        properties.put("mail.smtp.starttls.enable", "true");
		        properties.put("mail.smtp.host", SMTP_HOST_NAME);
		        properties.put("mail.smtp.user", USER_NAME);
		        properties.put("mail.smtp.password", PASSWORD);
		        properties.put("mail.smtp.port", SMTP_HOST_PORT);
		        properties.put("mail.smtp.auth", "true");
		        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		 
		        
//		     	System.out.println("\n\n 2nd ===> Get Mail Session..");

		        Authenticator auth = new Authenticator() {
		            public PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(USER_NAME, PASSWORD);
		            }
		        };
		        
		        Session session = Session.getInstance(properties, auth);        
		 

		        MimeMessage message = new MimeMessage(session);
		 
		        try {
		            message.setFrom(new InternetAddress(USER_NAME));
		            
		            InternetAddress[] bccAddress = new InternetAddress[bcc.length];
		            
		            // To get the array of bccaddresses
		            for( int i = 0; i < bcc.length; i++ ) {
		                bccAddress[i] = new InternetAddress(bcc[i]);
		            }
		            
		            // Set bcc: header field of the header.
		            for( int i = 0; i < bccAddress.length; i++) {
		                message.addRecipient(Message.RecipientType.BCC, bccAddress[i]);
		            }
		            
		            // Set Subject: header field
		            message.setSubject(subject);
		                                  
		            // set the date to actual message
		            message.setSentDate(new Date());
		            
		            // set the actual message
		            message.setContent(body,"text/html");         
		            
		            Transport transport = session.getTransport(MAIL_SERVER);
		            transport.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, USER_NAME, PASSWORD);
		            transport.sendMessage(message, message.getAllRecipients());
		            if(transport!=null)
		            	{
		            		transport.close();
		            		return true;
		            	}
		            
		            //System.out.println("Sent Message Successfully....");
		        }
		        catch (AddressException ae) {
		            ae.printStackTrace();
		        }
		        catch (MessagingException me) {
		            me.printStackTrace();
		        }	
		        return false;
		    }

	@Override
	public List<Trip> getTripDetails(String user_id) {
		List<Trip> trips = userInter.getTripDetails(user_id);
		if(trips!=null)
			return trips;
		else
			return null;
	}

	@Override
	public List<Booking> getBookingDetails(String user_id) {
		List<Booking> bookings = userInter.getBookingDetails(user_id);
		if(bookings!=null)
			return bookings;
		else
			return null;
	}
	
	
	
}
