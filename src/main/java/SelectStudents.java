import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectStudents {
    public static void main(String[] args) {

        try {
            Connection connection = DBConnection.getConnection();

            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM students LIMIT 5";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                int grade = resultSet.getInt("grade");

                System.out.println(
                        id + " " + firstname + " " + lastname + " " + grade
                );
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}