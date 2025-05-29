import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQL {

    static Connection conn;

    public static boolean canConnect(){
        String url = "jdbc:mysql://db-mysql-sgp1-information-management-do-user-9437339-0.l.db.ondigitalocean.com:25060/defaultdb?useSSL=true&requireSSL=true";
        String user = "hunter_exam_user";
        String pass = "AVNS_FZjhURUQoeysC1t3OjX";
		
        try {
            System.out.println("Connecting to database...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection successful!");

        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public static void run(String sql) {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void runWithResult(String sql) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<String> runGetResult(String sql) {
        List<String> result = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                result.add(rs.getString(1));
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public static List<String> runGetResultAll(String sql) {
        List<String> result = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String line = "";
                for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    line += rs.getString(i) + "::";
                }
                result.add(line);
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
