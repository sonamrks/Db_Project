
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class WholeQuery2{

	public int[] Values() {
		String[] tokens=null;
        int[] values = new int[484];

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException ce){
			System.out.println("Error loading driver: " + ce);
		}
		try{
		String host="testdb.oracle.com";
		String dbname="ORCL";
		String username="oracle_sonam";
		String password="oracle_sonam";
		int port=1521;
		String URL="jdbc:oracle:thin:@" + host + ":" + port+ ":" + dbname;
		Connection connection=DriverManager.getConnection(URL,username,password);
	    Statement statement=connection.createStatement();		
        
		for(int ct=0,t=0;ct<=241;ct++){
		String query="SELECT p.shape.Get_WKT() FROM photos p WHERE p.photo_id='Photo" + ct + "'";
	    ResultSet resultset=statement.executeQuery(query);
	    
	    while(resultset.next()){
            InputStream ip = resultset.getAsciiStream(1);
            BufferedReader br1 = new BufferedReader(new InputStreamReader(ip));
			String c;
            int[] points=new int[2];
			try {
				c = br1.readLine();
		                tokens = c.split("\\s+");
		                for (int i=1;i<=2;i++){
		                	if(i==1){
		                		String[] s1=tokens[i].split("[\\(]+");
		                		tokens[1]=s1[1];
		                	        }
		                	if(i==2){
		                		String s3[]=tokens[i].split("[\\)]+");
		                		tokens[2]=s3[0];
		                	        }
		                }
		                for (int a=1;a<=2;a++){
			                		String[] a1=tokens[a].split("[\\.]+");
			                		tokens[a]=a1[0];
			            }
		                
						for (int b=1;b<=2;b++){
		                	try {
		                		int num=Integer.parseInt(String.valueOf(tokens[b]));
		                		points[b-1]=num;
		                     	}
		                    catch (NumberFormatException e) {
		                    }
						} 		            
			            values[t]=points[0];
			            values[t+1]=points[1];
				}
		    catch (IOException e) {
				e.printStackTrace();
			} 
 	    }
        t=t+2;    
		}
	    connection.close();
		}
		catch(SQLException E){
			System.out.println("SQLException: " + E.getMessage());
			System.out.println("SQLState: " + E.getSQLState());
			System.out.println("VendorError: " + E.getErrorCode());
		}
		return values;
	}
}


