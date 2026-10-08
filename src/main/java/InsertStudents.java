import java.sql.Connection;
import java.sql.Statement;

public class InsertStudents {
    public static void main(String[] args) {

        try {
            Connection connection = DBConnection.getConnection();

            Statement statement = connection.createStatement();

            String sql = "INSERT INTO students (id, firstname, lastname, grade) VALUES " +
                    "(2, 'Hana', 'Tesfaye', 78), " +
                    "(3, 'Dawit', 'Kebede', 92), " +
                    "(4, 'Meron', 'Haile', 85), " +
                    "(5, 'Samuel', 'Tadesse', 74), " +
                    "(6, 'Liya', 'Mekonnen', 88), " +
                    "(7, 'Yonas', 'Getachew', 81), " +
                    "(8, 'Sara', 'Abebe', 95), " +
                    "(9, 'Nahom', 'Berhanu', 69), " +
                    "(10, 'Bethel', 'Alemu', 90), " +
                    "(11, 'Mimi', 'Girma', 76)";

            int rows = statement.executeUpdate(sql);

            System.out.println(rows + " students inserted successfully!");

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}