import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/StudentsDB";
        String username = "root";
        String password = System.getenv("DB_PASSWORD");
        return DriverManager.getConnection(
                url,
                username,
                password
        );
    }
}