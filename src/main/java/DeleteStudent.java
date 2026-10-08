import java.sql.Connection;
import java.sql.Statement;

public class DeleteStudent {
    public static void main(String[] args) {

        try {
            Connection connection = DBConnection.getConnection();

            Statement statement = connection.createStatement();

            String sql = "DELETE FROM students WHERE id = 11";

            int rows = statement.executeUpdate(sql);


            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}