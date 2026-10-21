import java.sql.*;

public class App {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/college";
            String user = "root";
            String password = "YOUR_PASSWORD"; // apna MySQL password likho

            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("✅ Connected Successfully");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}