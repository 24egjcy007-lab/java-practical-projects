import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Advanced Java Lab: Connect Java to MySQL using JDBC.
 *
 * Before running:
 * 1. Run database.sql in MySQL Workbench.
 * 2. Set DB_USER and DB_PASSWORD environment variables, or update the
 *    fallback values below for your local MySQL installation.
 */
public class MySQLConnect {
    private static final String URL =
            "jdbc:mysql://localhost:3306/studentdb?useSSL=false&serverTimezone=UTC";
    private static final String USER =
            System.getenv().getOrDefault("DB_USER", "root");
    private static final String PASSWORD =
            System.getenv().getOrDefault("DB_PASSWORD", "CHANGE_ME");

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to MySQL successfully!");

            createTableIfNeeded(connection);
            insertSampleStudent(connection, "Aarav Sharma", "aarav@example.com");
            displayStudents(connection);
        } catch (SQLException e) {
            System.err.println("Database connection/operation failed: " + e.getMessage());
            System.err.println("Check that MySQL Server is running, database.sql was executed,");
            System.err.println("and DB_USER / DB_PASSWORD match your MySQL credentials.");
        }
    }

    private static void createTableIfNeeded(Connection connection) throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS students (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    name VARCHAR(100) NOT NULL,
                    email VARCHAR(150) NOT NULL UNIQUE
                )
                """;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }

    private static void insertSampleStudent(
            Connection connection, String name, String email) throws SQLException {
        String sql = "INSERT IGNORE INTO students (name, email) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, email);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Sample student inserted.");
            } else {
                System.out.println("Sample student already exists; skipping duplicate.");
            }
        }
    }

    private static void displayStudents(Connection connection) throws SQLException {
        String sql = "SELECT id, name, email FROM students ORDER BY id";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("\nStudent Records");
            System.out.println("-----------------------------------------------");
            System.out.printf("%-6s %-22s %-28s%n", "ID", "NAME", "EMAIL");
            System.out.println("-----------------------------------------------");

            while (resultSet.next()) {
                System.out.printf("%-6d %-22s %-28s%n",
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"));
            }
        }
    }
}
