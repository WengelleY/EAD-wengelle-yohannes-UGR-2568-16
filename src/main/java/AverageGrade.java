import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AverageGrade {
    public static void main(String[] args) {

        try {
            Connection connection = DBConnection.getConnection();

            Statement statement = connection.createStatement();

            String sql = "SELECT AVG(grade) AS average_grade FROM students";

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                double averageGrade =
                        resultSet.getDouble("average_grade");

                System.out.println("Average grade: " + averageGrade);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}