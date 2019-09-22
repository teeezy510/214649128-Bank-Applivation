
import java.io.*;
import java.lang.Integer;
import java.net.*;
import java.util.ArrayList;
import java.sql.*;
  
import javax.servlet.*;
import javax.servlet.http.*;




public class DataInsert {
	public static void main(String[] args) {
		
		
		 }
	
	public void doGet(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException
{
String name = request.getParameter("name");
String sourcePass = request.getParameter("sourcePass");
String destPass = request.getParameter("destPass");
String destBank = request.getParameter("destBank");
String destCountry = request.getParameter("destCountry");
String accNum = request.getParameter("accNum");
String amount = request.getParameter("amount");
//function call
addToDatabase(name, sourcePass,destPass,destBank,destCountry, accNum, amount);

}  
	
	
	 private void addToDatabase (String name, String sourcePass, String destPass,String DestBank,String destCountry,String AccNum, String Amount,String TransacCode ) {
		// here we have country name and population ready
		// to be added to database...
		// very simple  example how to do it in MySQL
		String dbURL = "jdbc:mysql://localhost/ADH401";
		try {    
		    // we need db connection
		    Connection conn = DriverManager.getConnection( dbURL, "root", null );
		    // and statement to execute
		    Statement st = conn.createStatement();
		    // let's prepare SQL query: 'insert into...'
		    String insertQuery = "insert into account ( name, sourcePass, destPass, DestBank, destCountry, AccNum, Amount, TransacCode ) ";
		    insertQuery += " values ( '" + name +
		    "', '" 
		    + sourcePass + "','"
		    + destPass + "','"
		    + DestBank + "','"
		    + destCountry + "','"
		    + AccNum + "','"
		    + Amount + "','"
		    + TransacCode
		    +  "' )"; 
		    // print it for debug (appears in server log files)
		    System.out.println( "sql:" + insertQuery ); 
		    // let's exetute
		    st.execute ( insertQuery );    
		    // that's all folks...
		    conn.close();    
		} catch ( SQLException ex ) {
		    System.out.println( ex.getMessage() );
		}
		    }
}
