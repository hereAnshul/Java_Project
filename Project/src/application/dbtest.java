package application;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;

public class dbtest {
	static LocalDateTime t1;
	public static void main(String[] args) {
		System.out.println("Processing...");
		//update(null,"car", null, null);
	}
	public static void update(String a, String b, String c, String d) {
		Connection con=null;
		Statement stmt=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
			final String USER = "root";
			final String PASS = "";
			final String DB_URL = "jdbc:mysql://127.0.0.1:3306/javaproj";
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = con.createStatement();
			String SPOT = a;
			String NAME = c;
			String NUMP = d;
 			System.out.println(SPOT);
 			if(b=="car") {
 				t1 = LocalDateTime.now();
 				String sql = "INSERT INTO cspot VALUES('"+SPOT+"', '"+NAME+"', '"+NUMP+"', '"+t1+"')";
 				stmt.executeUpdate(sql);
 				ResultSet rs = stmt.executeQuery("SELECT * FROM cspot");
 				while(rs.next()) {	
 					System.out.println(rs.getString(1));	
 				}
 			}else if(b=="bike") {
 				t1 = LocalDateTime.now();
 				String sql = "INSERT INTO bspot VALUES('"+SPOT+"', '"+NAME+"', '"+NUMP+"', '"+t1+"')";
 				stmt.executeUpdate(sql);
 				ResultSet rs = stmt.executeQuery("SELECT * FROM bspot");
 				while(rs.next()) {	
 					System.out.println(rs.getString(1));	
 				}
 			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return;
	}
	public static long update(String a, String b, String c) {
		Connection con=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
			final String USER = "root";
			final String PASS = "";
			final String DB_URL = "jdbc:mysql://127.0.0.1:3306/javaproj";
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = con.createStatement();
			String SPOT = a;
			//String NUMP = c;
 			System.out.println(SPOT);
 			if(b=="car") {
 				ResultSet rs = stmt.executeQuery("SELECT * FROM cspot WHERE	sptno='"+SPOT+"'");
 				//rs.getString(1);
 				while(rs.next()) {
 					String t1 = rs.getString(4);
 					LocalDateTime dt = LocalDateTime.parse(t1);
 					LocalDateTime ent = LocalDateTime.now();
 					Duration duration = Duration.between(ent, dt);
 				    long diff = Math.abs(duration.toMinutes());
 					System.out.println(diff);
 					String sql = "DELETE FROM cspot WHERE sptno='"+SPOT+"';";
 	 				stmt.executeUpdate(sql);
 					return diff;
 				}
 			}else if(b=="bike") {
 				ResultSet rs = stmt.executeQuery("SELECT * FROM bspot WHERE sptno='"+SPOT+"'");
 				while(rs.next()) {	
 					String t1 = rs.getString(4);
					LocalDateTime dt = LocalDateTime.parse(t1);
					LocalDateTime ent = LocalDateTime.now();
					Duration duration = Duration.between(ent, dt);
				    long diff = Math.abs(duration.toMinutes());
					System.out.println(diff);
					String sql = "DELETE FROM bspot WHERE sptno='"+SPOT+"';";
					stmt.executeUpdate(sql);
					return diff;
 				}
 			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
