import java.io.*;
import java.net.*;
import java.sql.*;

public class Server
{
  public static void main(String[] args) throws Exception
  {
    ServerSocket sersock = new ServerSocket(3052);//starts
    int n=1;boolean var=true;
    String url = "jdbc:mysql://localhost:3306/db";
    String user = "root";
	String pass = "Sur@j1729";
	String receiveMessage="", sendMessage;   
    String query;//
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection(url, user, pass);
	Statement s = con.createStatement();
    System.out.println("Server  ready for chatting");
    Socket sock = sersock.accept( );                          
    BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
    OutputStream ostream = sock.getOutputStream(); 
    PrintWriter pwrite = new PrintWriter(ostream, true);
    InputStream istream = sock.getInputStream();
    BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
    while(var)
    {
		if(n==2)
    		var=false;
        if((receiveMessage = receiveRead.readLine()) != null)  
        {
           System.out.println(receiveMessage);         
        }         
        sendMessage = keyRead.readLine(); 
        pwrite.println(sendMessage);             
        pwrite.flush();
        n++;
    }
    ResultSet rs=s.executeQuery("select * from tab");
    System.out.println("\n Messages entered by client are:\n");
    while(rs.next())
		System.out.println(""+ ""+rs.getString("Client"));
  }                    
}