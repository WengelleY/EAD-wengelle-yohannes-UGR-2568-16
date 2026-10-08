import java.sql.Connection;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) {

        try {
            Connection connection = DBConnection.getConnection();

            System.out.println("Database connected successfully!");

            Statement statement = connection.createStatement();

            System.out.println("Statement created successfully!");

            statement.close();
            connection.close();

            System.out.println("Connection closed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}