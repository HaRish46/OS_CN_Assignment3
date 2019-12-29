/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abhiram.mail;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class TlsEmail {

	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (use authentication)
	   Use Authentication: Yes
	   Port for TLS/STARTTLS: 587
     * @param args
	 */
	public static void main(String[] args) throws IOException {
		 String fromEmail = "yeluriabhiram@gmail.com"; //requires valid gmail id
		 String password = "anirudh*1"; // correct password for gmail id
		 String toEmail = "leelapallava@gmail.com"; // can be any email id 
		
		System.out.println("Mail to be sent");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth;
            auth = new Authenticator() {
                //override the getPasswordAuthentication method
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };
		Session session = Session.getInstance(props, auth);
                DataInputStream in=new DataInputStream(System.in);
                System.out.println("Enter Title of the mail\n");
                String title=in.readLine();
                System.out.println("Enter message to be sent\n");
               
                String msg=in.readLine();
		
		EmailUtil.sendEmail(session, toEmail,title, msg);
                RSA.implement(msg);
		
	}
}
	