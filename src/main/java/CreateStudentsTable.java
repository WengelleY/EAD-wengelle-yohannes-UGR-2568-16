
import java.sql.Connection;
import java.sql.Statement;

public class CreateStudentsTable {
    public static void main(String[] args) {

        try {
            Connection connection = DBConnection.getConnection();

            Statement statement = connection.createStatement();

            String sql = "CREATE TABLE students (" +
                    "id INT PRIMARY KEY, " +
                    "firstname VARCHAR(50), " +
                    "lastname VARCHAR(50), " +
                    "grade INT)";

            statement.executeUpdate(sql);

            System.out.println("Students table created successfully!");

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}