import java.sql.Connection;
import java.sql.Statement;

public class UpdateStudent {
    public static void main(String[] args) {

        try {
            Connection connection = DBConnection.getConnection();

            Statement statement = connection.createStatement();

            String sql = "UPDATE students SET firstname = 'Abel' WHERE id = 1";

            int rows = statement.executeUpdate(sql);


            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}