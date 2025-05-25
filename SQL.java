import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQL {
    public static void main(String[] args) {
        String url = "jdbc:mysql://db-mysql-sgp1-information-management-do-user-9437339-0.l.db.ondigitalocean.com:25060/defaultdb?useSSL=true&requireSSL=true";
        String user = "hunter_exam_user";
        String pass = "AVNS_FZjhURUQoeysC1t3OjX";
		
		System.out.println("Connecting...");
		
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection successful!");

            System.out.println("DATABASES:");
            runWithResult(conn, "SHOW DATABASES;");
            run(conn, "USE hunter_exam;");
			
			System.out.println("\nTABLES:");
            runWithResult(conn, "SHOW TABLES;");

            conn.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void run(Connection conn, String sql) throws Exception {
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
        stmt.close();
    }

    public static void runWithResult(Connection conn, String sql) throws Exception {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        rs.close();
        stmt.close();
    }
}
