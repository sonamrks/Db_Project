import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class WholeQuery{

	public int[] xValues(int p){
		
		WholeQuery wq=new WholeQuery();
		int[] str=wq.Values(p);
		
    	int[] x=new int[str.length/2];

    	for(int i=0;i<str.length;){
    		for(int k=0;k<str.length/2;k++){
    			x[k]=str[i];
    			i=i+2;
    		}
    	}     
        return x;
		}
	
	public int[] yValues(int p){
		
		WholeQuery wq=new WholeQuery();
		int[] str=wq.Values(p);

    	int[] y=new int[str.length/2];

    	for(int j=1;j<str.length;){
    		for(int l=0;l<str.length/2;l++){
			y[l]=str[j];
			j=j+2;
    		}
		}
        
        return y;
		}

	public int[] Values(int ct) {
		String[] tokens=null;

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
		
		String query="SELECT bui.shape.Get_WKT() FROM buildings bui WHERE bui.build_id='b" + ct + "'";
	    ResultSet resultset=statement.executeQuery(query);
	    
	    while(resultset.next()){
            InputStream ip = resultset.getAsciiStream(1);
            BufferedReader br1 = new BufferedReader(new InputStreamReader(ip));
			String c;
			try {
				c = br1.readLine();
		                tokens = c.split("\\s+");
		                for (int i=1;i<tokens.length;i++){
		                	if(i==1){
		                		String[] s1=tokens[i].split("[\\((]+");
		                		tokens[i]=s1[1];
		                	        }
		                	if(i%2==0){
		                		String[] s2=tokens[i].split("[\\,]+");
		                		tokens[i]=s2[0];
		                	        }	
		                	if(i==(tokens.length-1)){
		                		String s3[]=tokens[i].split("[\\))]+");
		                		tokens[i]=s3[0];
		                	        }
		                }
		                for (int a=1;a<tokens.length;a++){
			                		String[] a1=tokens[a].split("[\\.]+");
			                		tokens[a]=a1[0];
			            }
		                	
		                int[] points=new int[tokens.length-1];
			            for (int b=1;b<tokens.length;b++){
			                	try {
			                		int num=Integer.parseInt(String.valueOf(tokens[b]));
			                		points[b-1]=num;
			                     	}
			                    catch (NumberFormatException e) {
			                    }
		                }	  
			         return points;   
				}
		    catch (IOException e) {
				e.printStackTrace();
			} 		
 	    }

	    connection.close();
		}
		catch(SQLException E){
			System.out.println("SQLException: " + E.getMessage());
			System.out.println("SQLState: " + E.getSQLState());
			System.out.println("VendorError: " + E.getErrorCode());
		}
		return null;
	}
}


