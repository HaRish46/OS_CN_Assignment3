import java.io.*;
import java.net.*;
import java.sql.*;

public class Client
{
  public static void main(String[] args) throws Exception
  {
	int n=1;
	boolean var=true;
    Socket sock = new Socket("127.0.0.1", 3052);
    String url = "jdbc:mysql://localhost:3306/db";
    String user = "root";
	String pass = "Sur@j1729";
	String receiveMessage="", sendMessage="hell";   
    String query;// = "insert into tab values('"+sendMessage+"')";
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection(url, user, pass);
	Statement s = con.createStatement();
    BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
    OutputStream ostream = sock.getOutputStream(); 
    PrintWriter pwrite = new PrintWriter(ostream, true);
    InputStream istream = sock.getInputStream();
    BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
    System.out.println("Start the chitchat, type and press Enter key");
    while(var)
    {
    	if(n==2)
			var=false;
        sendMessage = keyRead.readLine();
        query= "insert into tab values('"+sendMessage+"')";
        s.executeUpdate(query);
        pwrite.println(sendMessage); 
        pwrite.flush();                   
        if((receiveMessage = receiveRead.readLine()) != null) 
        {
            System.out.println(receiveMessage); 
        }  
        n++;
    } 
    ResultSet rs=s.executeQuery("select * from tab");
  }                    
}    